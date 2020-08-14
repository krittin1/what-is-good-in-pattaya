package com.pattaya.group1.web_service.controller;

import com.pattaya.group1.web_service.entity.ChangeLog;
import com.pattaya.group1.web_service.entity.Employee;
import com.pattaya.group1.web_service.entity.Information;
import com.pattaya.group1.web_service.model.Log;
import com.pattaya.group1.web_service.model.LogResponse;
import com.pattaya.group1.web_service.model.Object;
import com.pattaya.group1.web_service.repository.ChangeLogRepository;
import com.pattaya.group1.web_service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LogController {

    @Autowired
    private ChangeLogRepository changeLogRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @PostMapping("/user")
    public String createUser(@RequestBody Log log){
        ChangeLog changeLog = new ChangeLog(
                log.getObject().getFormId(),
                log.getObject().getUserId(),
                log.getObject().getAction(),
                log.getAdminId(),
                log.getMessage(),
                log.getTimeStamp());
        Employee employee = employeeRepository.findByUserId(log.getObject().getUserId());
        Information information = employee.getInformation();
        information.setFirstName(log.getObject().getName());
        information.setLastName(log.getObject().getSurname());
        information.setAddress(log.getObject().getAddress());
        information.setPostCode(log.getObject().getPostCode());
        information.setDateOfBirth(log.getObject().getDateOfBirth());
        information.setPhoneNumber(log.getObject().getPhoneNumber());
        information.setPosition(log.getObject().getPosition());
        information.setStartDate(log.getObject().getStartDate());
        information.setIdentityCardNo(log.getObject().getIdCard());
        employee.setRole(log.getObject().getPosition());
        employee.setStatus("ACTIVE");
        employee.setUserId(log.getObject().getUserId());
        employee.setInformation(information);
        changeLogRepository.save(changeLog);
        employeeRepository.save(employee);
        return employee.getUserId() + "user added";
    }

    @PutMapping("/user")
    public String updateUser(@RequestBody Log log){
        return "Put";
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@RequestParam String id){
        return "Delete";
    }

    @GetMapping("/logs")
    public LogResponse getLogs(
            @RequestParam(required = false) String userId,
            @RequestParam(defaultValue = "1",name = "page") int pageNumber,
            @RequestParam(defaultValue = "10",name = "item_per_page") int itemPerPage){

        List<ChangeLog> changeLogPage = changeLogRepository.findAll();
        Employee employee = employeeRepository.findByUserId(userId);
        List<Log> logResponseList = new ArrayList<>();
        for(ChangeLog changeLog: changeLogPage){
            logResponseList.add(new Log(
                    changeLog.getMessage(),
                    changeLog.getAdminId(),
                    changeLog.getAdminId(),
                    new Object(
                            changeLog.getAction(),
                            employee.getUserId(),
                            changeLog.getLogId(),
                            employee.getInformation().getFirstName(),
                            employee.getInformation().getLastName(),
                            employee.getInformation().getIdentityCardNo(),
                            employee.getInformation().getPostCode(),
                            employee.getInformation().getDateOfBirth(),
                            employee.getInformation().getPosition(),
                            employee.getInformation().getStartDate(),
                            employee.getInformation().getPhoneNumber(),
                            employee.getInformation().getAddress()
                            )
            ));
        }
        LogResponse logResponse = new LogResponse(changeLogPage.size(),pageNumber,itemPerPage,logResponseList);
        return logResponse;
    }
}
