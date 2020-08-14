package com.pattaya.group1.web_service.controller;

import com.pattaya.group1.web_service.model.Log;
import com.pattaya.group1.web_service.model.LogResponse;
import org.springframework.web.bind.annotation.*;

public class LogController {
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

    @GetMapping("logs")
    public LogResponse getLogs(@RequestParam String userId){
        return new LogResponse(10,0,5);
    }
}
