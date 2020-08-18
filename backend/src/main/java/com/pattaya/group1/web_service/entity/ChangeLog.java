package com.pattaya.group1.web_service.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

public class ChangeLog {
    @Id
    @JsonIgnore
    private String id;
    private String userId;
    private String action;
    private String adminId;
    private String message;
    private String timestamp;


    private ChangeLog(String userId, String action, String adminId, String message, String timestamp) {
        this.userId = userId;
        this.action = action;
        this.adminId = adminId;
        this.message = message;
        this.timestamp = timestamp;
    }


    public static class Builder {
        private String userId;
        private String action;
        private String adminId;
        private String message;
        private String timestamp;

        public Builder withUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder withAction(String action) {
            this.action = action;
            return this;
        }

        public Builder withAdminId(String adminId) {
            this.adminId = adminId;
            return this;
        }

        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder withTimestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ChangeLog build() {
            return new ChangeLog(userId, action, adminId, message, timestamp);
        }
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ChangeLog{" +
                ", userId='" + userId + '\'' +
                ", action='" + action + '\'' +
                ", adminId='" + adminId + '\'' +
                ", message='" + message + '\'' +
                ", timeStamp='" + timestamp + '\'' +
                '}';
    }
}
