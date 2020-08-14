package com.pattaya.group1.web_service.repository;

import com.pattaya.group1.web_service.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
