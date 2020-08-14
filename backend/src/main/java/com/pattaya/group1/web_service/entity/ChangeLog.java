package com.pattaya.group1.web_service.entity;


public class ChangeLog {
    private String userId;
    private String action;
    private String adminId;
    private String message;
    private String timestamp;



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
