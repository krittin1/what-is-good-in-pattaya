package com.pattaya.group1.web_service.controller;

import com.pattaya.group1.web_service.entity.ChangeLog;
import com.pattaya.group1.web_service.repository.ChangeLogRepository;
import com.pattaya.group1.web_service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/changelogs")
public class ChangeLogController {



    private final Logger logger = Logger.getLogger(ChangeLogController.class.getName());
    @Autowired
    private ChangeLogRepository changeLogRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    // Helper endpoints for debugging
    @GetMapping({"/{id}", ""})
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
}
