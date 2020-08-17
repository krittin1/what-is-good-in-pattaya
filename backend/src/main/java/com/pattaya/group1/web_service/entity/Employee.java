package com.pattaya.group1.web_service.entity;


import org.springframework.data.annotation.Id;

public class Employee {
    @Id
    private String id;
    private String userId;
    private String role;
    private String status;
    private Information information;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Employee() {
    }

    public Employee(String userId, String role, String status, Information information) {
        this.userId = userId;
        this.role = role;
        this.status = status;
        this.information = information;
    }

    public Employee(Employee employee) {
        this(employee.userId, employee.role, employee.status, employee.information);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "userId='" + userId + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                ", information=" + information +
                '}';
    }
}
