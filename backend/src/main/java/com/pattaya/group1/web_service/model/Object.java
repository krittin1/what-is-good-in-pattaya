package com.pattaya.group1.web_service.model;

public class Object {
    private String action;
    private String userId;
    private String formId;
    private String name;
    private String surname;
    private String idCard;
    private String postCode;

    public Object(String action, String userId, String formId, String name, String surname, String idCard, String postCode) {
        this.action = action;
        this.userId = userId;
        this.formId = formId;
        this.name = name;
        this.surname = surname;
        this.idCard = idCard;
        this.postCode = postCode;
    }


    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
