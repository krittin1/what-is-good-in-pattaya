package com.pattaya.group1.web_service.entity;


public class Employee {
    private String userId;
    private String role;
    private String status;

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

    private Information information;

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
