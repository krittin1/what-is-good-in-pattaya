package com.pattaya.group1.web_service.controller;

import com.pattaya.group1.web_service.entity.Address;
import com.pattaya.group1.web_service.entity.ChangeLog;
import com.pattaya.group1.web_service.entity.Employee;
import com.pattaya.group1.web_service.entity.Information;
import com.pattaya.group1.web_service.model.Log;
import com.pattaya.group1.web_service.model.LogResponse;
import com.pattaya.group1.web_service.model.Object;
import com.pattaya.group1.web_service.repository.ChangeLogRepository;
import com.pattaya.group1.web_service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class LogController {

    private final Logger logger = Logger.getLogger(LogController.class.getName());
    @Autowired
    private ChangeLogRepository changeLogRepository;
    @Autowired
    private EmployeeRepository employeeRepository;


    @PostMapping("/user")
    public ResponseEntity<Map<String, String>> createUser(@RequestBody Log log) {
        Employee employee = employeeRepository.findByUserId(log.getObject().getUserId());
        if (employee != null) {
            employeeRepository.deleteByUserId(log.getObject().getUserId());
        }
        employee = buildEmployeeOnLog(log, "Active");
        employeeRepository.save(employee);
        ChangeLog changeLog = buildChangeLogOnLog(log, "Added", log.getChangedFields());
        changeLogRepository.save(changeLog);
        Map<String, String> map = Stream.of(
                new AbstractMap.SimpleEntry<>("message", String.format("%s user added", log.getObject().getUserId()))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return ResponseEntity.status(201).body(map);
    }


    // Will it be wiser if we know what fields have change so that we can't adjust the field accordingly ?
    @PutMapping("/user")
    public ResponseEntity<Map<String, String>> updateUser(@RequestBody Log log) {
        Employee employee = employeeRepository.findByUserId(log.getObject().getUserId());
        // Save the employee first;
        if (employee == null) {
            throw new EmployeeNotFound("Cannot find the user whose id is `" + log.getObject().getUserId() + "` in the database.");
        }

        for (String changeField : log.getChangedFields()) {
            setEmployee(changeField, employee, log);
        }
        employeeRepository.save(employee);

        ChangeLog changeLog = buildChangeLogOnLog(log, "Edited", log.getChangedFields());
        // Create new Log
        changeLogRepository.save(changeLog);
        Map<String, String> map = Stream.of(
                new AbstractMap.SimpleEntry<>("message", String.format("%s user updated", log.getObject().getUserId()))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return ResponseEntity.status(200).body(map);
    }

    private void setEmployee(String changeField, Employee employee, Log log) {
        Information information = employee.getInformation();
        Address address = employee.getInformation().getAddress();
        if ("name".equals(changeField))
            information.setFirstName(log.getObject().getName());
        if ("surname".equals(changeField))
            information.setLastName(log.getObject().getSurname());
        if ("postcode".equals(changeField))
            address.setPostcode(log.getObject().getPostcode());
        if ("position".equals(changeField))
            information.setPosition(log.getObject().getPosition());
        if ("phoneNumber".equals(changeField))
            information.setPhoneNumber(log.getObject().getPhoneNumber());
        if ("address".equals(changeField))
            address.setCurrentAddress(log.getObject().getAddress());

    }

    @DeleteMapping("/user")
    public ResponseEntity<Map<String, String>> deleteUser(@RequestBody Log log) {
        Employee employee = employeeRepository.findByUserId(log.getObject().getUserId());
        if (employee == null) {
            throw new EmployeeNotFound("Cannot find the user whose id is `" + log.getObject().getUserId() + "` in the database.");
        }
        if ("Terminated".equals(employee.getStatus())) {
            throw new DoubleTerminatedEmployeeException("Employee whose id is " + log.getObject().getUserId() + " is already terminated");
        }
        employee.setStatus("Terminated");
        employeeRepository.save(employee);
        ChangeLog changeLog = buildChangeLogOnLog(log, "Terminated", log.getChangedFields());
        changeLogRepository.save(changeLog);
        Map<String, String> map = Stream.of(
                new AbstractMap.SimpleEntry<>("message", String.format("%s user deleted", employee.getUserId()))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return ResponseEntity.status(200).body(map);
    }


    @GetMapping("/logs")
    public LogResponse getLogs(
            @RequestParam(required = false) String userId,
            @RequestParam(defaultValue = "0", name = "page") int pageNumber,
            @RequestParam(defaultValue = "10", name = "item_per_page") int itemPerPage) {

        Page<ChangeLog> changeLogPage;
        if (userId != null) {
            changeLogPage = changeLogRepository.findByUserId(PageRequest.of(pageNumber, itemPerPage), userId);


        } else {

            changeLogPage = changeLogRepository.findAll(PageRequest.of(pageNumber, itemPerPage));

        }
        List<Log> logResponseList = new ArrayList<>();
        for (ChangeLog changeLog : changeLogPage) {
            Employee userEmployee = employeeRepository.findByUserId(changeLog.getUserId());
            logResponseList.add(new Log(
                    changeLog.getMessage(),
                    changeLog.getAdminId(),
                    new Object(
                            changeLog.getAction(),
                            userEmployee.getUserId(),
                            userEmployee.getInformation().getFirstName(),
                            userEmployee.getInformation().getLastName(),
                            userEmployee.getInformation().getIdentityCardNo(),
                            userEmployee.getInformation().getAddress().getPostcode(),
                            userEmployee.getInformation().getDateOfBirth(),
                            userEmployee.getInformation().getPosition(),
                            userEmployee.getInformation().getStartDate(),
                            userEmployee.getInformation().getPhoneNumber(),
                            userEmployee.getInformation().getAddress().getCurrentAddress()
                    ),
                    changeLog.getTimestamp()
            ));
        }
        return new LogResponse(changeLogPage.getNumberOfElements(), pageNumber, itemPerPage, logResponseList);

    }

    // Helper endpoints for debugging only
    @GetMapping("/users/{id}")
    public List<Employee> getEmployee(@PathVariable(required = true) String id) {
        Employee employee = employeeRepository.findByUserId(id);
        if (employee == null) {
            throw new EmployeeNotFound("Cannot find the user whose id is `" + id  + "` in the database.");
        }
        return Collections.singletonList(employeeRepository.findByUserId(id));
    }


    @GetMapping("/users")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


    // Helper endpoints for debugging
    @GetMapping({"/changelogs/{id}", "/changelogs"})
    public List<ChangeLog> found(@PathVariable(required = false) String id, @RequestParam(required = false, defaultValue = "0") int page,
                                 @RequestParam(required = false, defaultValue = "10") int numberOfElements) {
        Page<ChangeLog> changeLogs;
        if (id != null)
            changeLogs = changeLogRepository.findByUserId(PageRequest.of(page, numberOfElements), id);
        else {
            changeLogs = changeLogRepository.findAll(PageRequest.of(page, numberOfElements));
        }
        return changeLogs.toList();
    }


    private ChangeLog buildChangeLogOnLog(Log log, String action, List<String> changedFields) {
        if (changedFields != null) {
            logger.info(changedFields.toString());
        }
        return new ChangeLog.Builder()
                .withAction(action)
                .withAdminId(log.getAdminId())
                .withMessage(log.getMessage() + ((changedFields != null) ? ("Fields Changed => " + changedFields.toString()) : ""))
                .withUserId(log.getObject().getUserId())
                .withTimestamp(new Date().toString()).build();
    }

    private Employee buildEmployeeOnLog(Log log, String status) {


        Object object = log.getObject();

        return new Employee.Builder()
                .withRole("Employee")
                .withStatus(status)
                .withUserId(object.getUserId())
                .withInformation(
                        new Information.Builder()
                                .withFirstName(object.getName())
                                .withDateOfBirth(object.getDateOfBirth())
                                .withLastName(object.getSurname())
                                .withIdentificationCardNo(object.getIdCard())
                                .withPhoneNumber(object.getPhoneNumber())
                                .withPosition(object.getPosition())
                                .withStartDate(object.getStartDate())
                                .withAddress(
                                        new Address.Builder()
                                                .withCurrentAddress(object.getAddress())
                                                .withPostcode(object.getPostcode())
                                                .build()
                                )
                                .build()
                ).build();
    }


    @ExceptionHandler({EmployeeNotFound.class, DoubleTerminatedEmployeeException.class})
    public ResponseEntity<String> exception(RuntimeException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}


