package com.pattaya.group1.web_service.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

public class Employee {
    @JsonIgnore
    @Id
    private String id;
    private String userId;
    private String role;
    private String status;
    private Information information;

    private Employee() {
    }

    public static class Builder {

        private String id;
        private String userId;
        private String role;
        private String status;
        private Information information;


        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder withRole(String role) {
            this.role = role;
            return this;
        }

        public Builder withStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder withInformation(Information information) {
            this.information = information;
            return this;
        }

        public Employee build() {
            Employee employee = new Employee();
            employee.id = this.id;
            employee.userId = this.userId;
            employee.role = this.role;
            employee.status = this.status;
            employee.information = this.information;
            return employee;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                ", information=" + information +
                '}';
    }
}
