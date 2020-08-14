package com.pattaya.group1.web_service.controller;

import com.pattaya.group1.web_service.entity.ChangeLog;
import com.pattaya.group1.web_service.entity.Employee;
import com.pattaya.group1.web_service.model.Log;
import com.pattaya.group1.web_service.model.LogResponse;
import com.pattaya.group1.web_service.model.Object;
import com.pattaya.group1.web_service.repository.ChangeLogRepository;
import com.pattaya.group1.web_service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
        return "Post";
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
                            employee.getFirstName(),
                            employee.getLastName(),
                            employee.getIdentityCardNo(),
                            employee.getPostCode()
                            )
            ));
        }
        LogResponse logResponse = new LogResponse(changeLogPage.size(),pageNumber,itemPerPage,logResponseList);
        return logResponse;
    }
}
