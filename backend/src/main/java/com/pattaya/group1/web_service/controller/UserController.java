package com.pattaya.group1.web_service.controller;

import com.pattaya.group1.web_service.entity.Address;
import com.pattaya.group1.web_service.entity.ChangeLog;
import com.pattaya.group1.web_service.entity.Employee;
import com.pattaya.group1.web_service.entity.Information;
import com.pattaya.group1.web_service.exception.DoubleTerminatedEmployeeException;
import com.pattaya.group1.web_service.exception.EmployeeNotFound;
import com.pattaya.group1.web_service.model.Log;
import com.pattaya.group1.web_service.model.Object;
import com.pattaya.group1.web_service.repository.ChangeLogRepository;
import com.pattaya.group1.web_service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final Logger logger = Logger.getLogger(UserController.class.getName());
    @Autowired
    private ChangeLogRepository changeLogRepository;
    @Autowired
    private EmployeeRepository employeeRepository;


    @PostMapping
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
        ChangeLog changeLog = buildChangeLogOnLog(log, "Added", "Added user " + log.getObject().getUserId() + ((addedAgain) ? " again." : ""));
        changeLogRepository.save(changeLog);
        Map<String, String> map = Stream.of(
                new AbstractMap.SimpleEntry<>("message", String.format("%s user added", log.getObject().getUserId()))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return ResponseEntity.status(201).body(map);
    }


    @PutMapping
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
        if (log.getObject().getName() != null && !log.getObject().getName().equals(information.getFirstName())) {
            information.setFirstName(log.getObject().getName());
            changes.add("first name");
        }
        if (log.getObject().getSurname() != null && !log.getObject().getSurname().equals(information.getLastName())) {
            information.setLastName(log.getObject().getSurname());
            changes.add("last name");
        }
        if (log.getObject().getPostcode() != null && !log.getObject().getPostcode().equals(information.getAddress().getPostcode())) {
            address.setPostcode(log.getObject().getPostcode());
            changes.add("postcode");
        }
        if (log.getObject().getPosition() != null && !log.getObject().getPosition().equals(information.getPosition())) {


            information.setPosition(log.getObject().getPosition());
            changes.add("position");
        }
        if (log.getObject().getPhoneNumber() != null && !log.getObject().getPhoneNumber().equals(information.getPhoneNumber())) {
            information.setPhoneNumber(log.getObject().getPhoneNumber());
            changes.add("phone number");
        }
        if (log.getObject().getAddress() != null && !log.getObject().getAddress().equals(information.getAddress().getCurrentAddress())) {
            address.setCurrentAddress(log.getObject().getAddress());
            changes.add("address");
        }

        employeeRepository.save(employee);

        ChangeLog changeLog = buildChangeLogOnLog(log, "Edited", String.format(
                "Changed %s of user %s", changes.toString(), log.getObject().getUserId())
        );
        // Create new Log
        changeLogRepository.save(changeLog);
        Map<String, String> map = Stream.of(
                new AbstractMap.SimpleEntry<>("message", String.format("Change %s of user %s", changes.toString(), log.getObject().getUserId()))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return ResponseEntity.status(200).body(map);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable String id, @RequestParam String adminId, @RequestParam String timestamp) {
        logger.info("Delete => user " + id);
        Employee employee = employeeRepository.findByUserId(id);
        boolean isDeleted = false;
        if (employee == null) {
            throw new EmployeeNotFound("Cannot find the user whose id is `" + id + "` in the database.");
        }
        if ("DELETED".equals(employee.getStatus())) {
//            throw new DoubleTerminatedEmployeeException("Employee whose id is " + id + " is already terminated");
            isDeleted = true;
        }
        employee.setStatus("DELETED");
        employeeRepository.save(employee);
        ChangeLog changeLog = new ChangeLog.Builder().withUserId(id).withAction("Deleted").withAdminId(adminId).withMessage("Deleted user " + id + ((isDeleted) ? " again" : "")).withTimestamp(timestamp).build();
        changeLogRepository.save(changeLog);
        Map<String, String> map = Stream.of(
                new AbstractMap.SimpleEntry<>("message", String.format("%s user deleted", employee.getUserId()))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return ResponseEntity.status(200).body(map);
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


