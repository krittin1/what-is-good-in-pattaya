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
    public ResponseEntity<Map<String,String>> createUser(@RequestBody Log log) {
        System.out.println(log.toString());
        Employee employee = employeeRepository.findByUserId(log.getObject().getUserId());
        if(employee != null){
            employeeRepository.deleteByUserId(log.getObject().getUserId());
        }
        // create new user
        employee = new Employee();
        employee.setRole("Employee");
        employee.setStatus("ACTIVE");

        Object object = log.getObject();
        employee.setUserId(object.getUserId());

        Information information = new Information();
        information.setDateOfBirth(object.getDateOfBirth());
        information.setFirstName(object.getName());
        information.setLastName(object.getSurname());
        information.setIdentityCardNo(object.getIdCard());
        information.setPhoneNumber(object.getPhoneNumber());
        information.setPosition(object.getPosition());
        information.setStartDate(object.getStartDate());
        employee.setInformation(information);

        Address address = new Address();
        address.setCurrentAddress(object.getAddress());
        address.setPostcode(object.getPostcode());

        information.setAddress(address);
        // Save the employee first;
        employeeRepository.save(employee);

        ChangeLog changeLog = new ChangeLog();
        changeLog.setAction(object.getAction());
        changeLog.setAdminId(log.getAdminId());
        changeLog.setMessage(log.getMessage());
        changeLog.setTimestamp(log.getTimestamp());
        changeLog.setUserId(object.getUserId());

        changeLogRepository.save(changeLog);
        // Create new Log
        Map<String, String> map = Stream.of(
                new AbstractMap.SimpleEntry<>("message", String.format("%s user added", log.getObject().getUserId()))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return ResponseEntity.status(201).body(map);
    }

    @PutMapping("/user")
    public ResponseEntity<Map<String,String>> updateUser(@RequestBody Log log) {
        Employee employee = employeeRepository.findByUserId(log.getObject().getUserId());
        Object object = log.getObject();
        employee.setUserId(object.getUserId());

        Information information = employee.getInformation();
        information.setDateOfBirth(object.getDateOfBirth());
        information.setFirstName(object.getName());
        information.setLastName(object.getSurname());
        information.setIdentityCardNo(object.getIdCard());
        information.setPhoneNumber(object.getPhoneNumber());
        information.setPosition(object.getPosition());
        information.setStartDate(object.getStartDate());
        Address address = new Address();
        address.setCurrentAddress(object.getAddress());
        address.setPostcode(object.getPostcode());
        information.setAddress(address);
        employee.setInformation(information);

        // Save the employee first;
        employeeRepository.save(employee);

        ChangeLog changeLog = new ChangeLog();
        changeLog.setAction(log.getObject().getAction());
        changeLog.setAdminId(log.getAdminId());
        changeLog.setMessage(log.getMessage());
        changeLog.setTimestamp(log.getTimestamp());
        changeLog.setUserId(log.getObject().getUserId());

        // Create new Log
        changeLogRepository.save(changeLog);
        Map<String, String> map = Stream.of(
                new AbstractMap.SimpleEntry<>("message",String.format("%s user updated", log.getObject().getUserId()))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return ResponseEntity.status(200).body(map);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Map<String,String>> deleteUser(@PathVariable String id,@RequestBody Log log) {
        Employee employee = employeeRepository.findByUserId(id);
        employee.setStatus("TERMINATED");
        employeeRepository.save(employee);
        ChangeLog changeLog = new ChangeLog();
        changeLog.setAction(log.getObject().getAction());
        changeLog.setAdminId(log.getAdminId());
        changeLog.setMessage(log.getMessage());
        changeLog.setTimestamp(log.getTimestamp());
        changeLog.setUserId(log.getObject().getUserId());

        changeLogRepository.save(changeLog);
        Map<String, String> map = Stream.of(
                new AbstractMap.SimpleEntry<>("message",String.format("%s user deleted", employee.getUserId()))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
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
            System.out.println(changeLog.getUserId());
            System.out.println(userEmployee.toString());
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
    public String found(@PathVariable(required = false) String id, @RequestParam(required = false, defaultValue = "0") int page,
                        @RequestParam(required = false, defaultValue = "10") int numberOfElements) {
        Page<ChangeLog> changeLogs;
        if (id != null)
            changeLogs = changeLogRepository.findByUserId(PageRequest.of(page, numberOfElements), id);
        else {
            changeLogs = changeLogRepository.findAll(PageRequest.of(page, numberOfElements));
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (ChangeLog changeLog : changeLogs) {
            stringBuilder.append(changeLog.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
