package com.pattaya.group1.web_service.model;

public class Object {
    private String action;
    private String userId;
    private String name;
    private String surname;
    private String idCard;
    private String postcode;

    public Object(String action, String userId, String name, String surname, String idCard, String postCode) {
        this.action = action;
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.idCard = idCard;
        this.postcode = postCode;
    }



    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
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

    @Override
    public String toString() {
        return "Object{" +
                "action='" + action + '\'' +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", idCard='" + idCard + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }
}
