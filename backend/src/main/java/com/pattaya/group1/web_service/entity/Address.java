package com.pattaya.group1.web_service.entity;

public class Address {
    private String currentAddress;
    private String postcode;

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "currentAddress='" + currentAddress + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }
}
