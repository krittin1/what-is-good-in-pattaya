package com.pattaya.group1.web_service.entity;


public class ChangeLog {
    private String logId;
    private String userId;
    private String action;
    private String adminId;
    private String message;
    private String timeStamp;

    public ChangeLog(String logId, String userId, String action, String adminId, String message, String timeStamp) {
        this.logId = logId;
        this.userId = userId;
        this.action = action;
        this.adminId = adminId;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
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

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "ChangeLog{" +
                "logId='" + logId + '\'' +
                ", userId='" + userId + '\'' +
                ", action='" + action + '\'' +
                ", adminId='" + adminId + '\'' +
                ", message='" + message + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }
}
