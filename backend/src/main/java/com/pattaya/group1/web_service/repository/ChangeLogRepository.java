package com.pattaya.group1.web_service.repository;

import com.pattaya.group1.web_service.entity.ChangeLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChangeLogRepository extends MongoRepository<ChangeLog, String> {
}
