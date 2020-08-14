package com.pattaya.group1.web_service.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class AppConfig {

    @Value("${mongo.password}")
    private String mongoPassword;

    public @Bean
    MongoClient mongoClient() {
        return MongoClients.create("mongodb+srv://natthawitjan:"+ mongoPassword+ "@cluster0.43gan.gcp.mongodb.net/mydatabase?retryWrites=true&w=majority");
    }

    public @Bean
    MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "mydatabase");
    }
}

