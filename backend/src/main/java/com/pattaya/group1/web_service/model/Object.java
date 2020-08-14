package com.pattaya.group1.web_service.model;

public class Object {
    private String action;
    private String userId;
    private String formId;
    private String name;
    private String surname;
    private String idCard;
    private String postCode;
    private String dateOfBirth;
    private String position;
    private String startDate;
    private String phoneNumber;
    private String address;

    public Object(String action, String userId, String formId, String name, String surname, String idCard, String postCode, String dateOfBirth, String position, String startDate, String phoneNumber, String address) {
        this.action = action;
        this.userId = userId;
        this.formId = formId;
        this.name = name;
        this.surname = surname;
        this.idCard = idCard;
        this.postCode = postCode;
        this.dateOfBirth = dateOfBirth;
        this.position = position;
        this.startDate = startDate;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
