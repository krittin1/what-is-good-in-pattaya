package com.pattaya.group1.web_service.controller;

import com.pattaya.group1.web_service.entity.ChangeLog;
import com.pattaya.group1.web_service.model.Log;
import com.pattaya.group1.web_service.model.LogResponse;
import com.pattaya.group1.web_service.repository.ChangeLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LogController {

    @Autowired
    private ChangeLogRepository changeLogRepository;
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
    public List<ChangeLog> getLogs(@RequestParam(required = false) String userId){
        ChangeLog changeLog = new ChangeLog();
        changeLog.setAction("ADD");
        changeLog.setAdminId("phisonkha");
        changeLog.setTimeStamp("10:00");
        changeLogRepository.save(changeLog);
        return changeLogRepository.findAll();
    }
}
