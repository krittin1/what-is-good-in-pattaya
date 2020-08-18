package com.pattaya.group1.web_service.model;

public class Log {
    private String message;
    private String adminId;
    private Object object;
    private String timestamp;


    public Log(String message, String adminId, Object object, String timestamp) {
        this.message = message;
        this.adminId = adminId;
        this.object = object;
        this.timestamp = timestamp;
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


    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Log{" +
                "message='" + message + '\'' +
                ", adminId='" + adminId + '\'' +
                ", object=" + object +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
