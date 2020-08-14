package com.pattaya.group1.web_service.model;

public class Log {
    private String message;
    private String adminId;
    private String adminUser;
    private Object object;
    private String timeStamp;

    public Log(String message, String adminId, String adminUser, Object object) {
        this.message = message;
        this.adminId = adminId;
        this.adminUser = adminUser;
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(String adminUser) {
        this.adminUser = adminUser;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
