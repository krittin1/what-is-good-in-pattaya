package com.pattaya.group1.web_service.repository;

import com.pattaya.group1.web_service.entity.ChangeLog;
import com.pattaya.group1.web_service.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Employee findByUserId(String userId);
    Employee deleteByUserId(String userId);
}
