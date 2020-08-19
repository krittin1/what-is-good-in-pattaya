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
        logger.info("Create => " + log.toString());
        Employee employee = employeeRepository.findByUserId(log.getObject().getUserId());
        boolean addedAgain = false;
        if (employee != null) {
            employeeRepository.deleteByUserId(log.getObject().getUserId());
            addedAgain = true;
        }
        employee = buildEmployeeOnLog(log);
        employeeRepository.save(employee);
        ChangeLog changeLog = buildChangeLogOnLog(log, "Added", "Add user " + log.getObject().getUserId() + ((addedAgain) ? " again." : ""));
        changeLogRepository.save(changeLog);
        Map<String, String> map = Stream.of(
                new AbstractMap.SimpleEntry<>("message", String.format("%s user added", log.getObject().getUserId()))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return ResponseEntity.status(201).body(map);
    }


    // Will it be wiser if we know what fields have change so that we can't adjust the field accordingly ?
    @PutMapping("/user")
    public ResponseEntity<Map<String, String>> updateUser(@RequestBody Log log) {
        logger.info("Update => " + log.toString());
        Employee employee = employeeRepository.findByUserId(log.getObject().getUserId());
        // Save the employee first;
        if (employee == null) {
            throw new EmployeeNotFound("Cannot find the user whose id is `" + log.getObject().getUserId() + "` in the database.");
        }
        List<String> changes = new ArrayList<>();
        Information information = employee.getInformation();
        Address address = employee.getInformation().getAddress();
        if (log.getObject().getName() != null) {
            information.setFirstName(log.getObject().getName());
            changes.add("first name");
        }
        if (log.getObject().getSurname() != null) {
            information.setLastName(log.getObject().getSurname());
            changes.add("last name");
        }
        if (log.getObject().getPostcode() != null) {
            address.setPostcode(log.getObject().getPostcode());
            changes.add("postcode");
        }
        if (log.getObject().getPosition() != null) {


            information.setPosition(log.getObject().getPosition());
            changes.add("position");
        }
        if (log.getObject().getPhoneNumber() != null) {
            information.setPhoneNumber(log.getObject().getPhoneNumber());
            changes.add("phone number");
        }
        if (log.getObject().getAddress() != null) {
            address.setCurrentAddress(log.getObject().getAddress());
            changes.add("address");
        }

        employeeRepository.save(employee);

        ChangeLog changeLog = buildChangeLogOnLog(log, "Edited", String.format(
                "Change %s of user %s", changes.toString(), log.getObject().getUserId())
        );
        // Create new Log
        changeLogRepository.save(changeLog);
        Map<String, String> map = Stream.of(
                new AbstractMap.SimpleEntry<>("message", String.format("Change %s of user %s", changes.toString(), log.getObject().getUserId()))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return ResponseEntity.status(200).body(map);

    }


    @DeleteMapping("/user/{id}")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable String id, @RequestParam String adminId, @RequestParam String timestamp) {
        logger.info("Terminate => user " + id);
        Employee employee = employeeRepository.findByUserId(id);
        if (employee == null) {
            throw new EmployeeNotFound("Cannot find the user whose id is `" + id + "` in the database.");
        }
        if ("TERMINATED".equals(employee.getStatus())) {
            throw new DoubleTerminatedEmployeeException("Employee whose id is " + id + " is already terminated");
        }
        employee.setStatus("TERMINATED");
        employeeRepository.save(employee);
        ChangeLog changeLog = new ChangeLog.Builder().withUserId(id).withAction("Terminated").withAdminId(adminId).withMessage("Terminated user " + id).withTimestamp(timestamp).build();
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

        logger.info("Get all logs... ");
        Page<ChangeLog> changeLogPage;
        if (userId != null) {
            changeLogPage = changeLogRepository.findByUserIdOrderByIdDesc(PageRequest.of(pageNumber, itemPerPage), userId);


        } else {

            changeLogPage = changeLogRepository.findAllByOrderByIdDesc(PageRequest.of(pageNumber, itemPerPage));

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
    public Employee getEmployee(@PathVariable(required = true) String id) {
        Employee employee = employeeRepository.findByUserId(id);
        if (employee == null) {
            throw new EmployeeNotFound("Cannot find the user whose id is `" + id + "` in the database.");
        }
        return employee;
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
            changeLogs = changeLogRepository.findByUserIdOrderByIdDesc(PageRequest.of(page, numberOfElements), id);
        else {
            changeLogs = changeLogRepository.findAll(PageRequest.of(page, numberOfElements));
        }
        return changeLogs.toList();
    }


    private ChangeLog buildChangeLogOnLog(Log log, String action, String message) {
        return new ChangeLog.Builder()
                .withAction(action)
                .withAdminId(log.getAdminId())
                .withMessage(message)
                .withUserId(log.getObject().getUserId())
                .withTimestamp(log.getTimestamp()).build();
    }

    private Employee buildEmployeeOnLog(Log log) {


        Object object = log.getObject();

        return new Employee.Builder()
                .withRole("Employee")
                .withStatus("Active")
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


