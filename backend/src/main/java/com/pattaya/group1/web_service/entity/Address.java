package com.pattaya.group1.web_service.entity;

public class Address {
    private String currentAddress;
    private String postcode;

    private Address() {}

    public static class  Builder {
        private String currentAddress;
        private String postcode;

        public Builder withCurrentAddress(String currentAddress) {
            this.currentAddress = currentAddress;
            return this;
        }
        public Builder withPostcode(String postcode) {
            this.postcode = postcode;
            return this;
        }
        public Address build() {
            Address address = new Address();
            address.currentAddress = this.currentAddress;
            address.postcode = this.postcode;
            return address;
        }

    }
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
