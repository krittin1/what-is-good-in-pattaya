package com.pattaya.group1.web_service.entity;

public class Information {
    private String firstName;
    private String lastName;
    private Address address;
    private String dateOfBirth;
    private String phoneNumber;
    private String position;
    private String startDate;
    private String identityCardNo;

    private Information() {
    }

    public static class Builder {

        private String firstName;
        private String lastName;
        private Address address;
        private String dateOfBirth;
        private String phoneNumber;
        private String position;
        private String startDate;
        private String identityCardNo;

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder withDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder withPosition(String position) {
            this.position = position;
            return this;
        }

        public Builder withStartDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder withIdentificationCardNo(String identificationCardNo) {
            this.identityCardNo = identificationCardNo;
            return this;
        }

        public Information build() {
            Information information = new Information();
            information.firstName = this.firstName;
            information.lastName = this.lastName;
            information.address = this.address;
            information.phoneNumber = this.phoneNumber;
            information.dateOfBirth = this.dateOfBirth;
            information.position = this.position;
            information.startDate = this.startDate;
            information.identityCardNo = this.identityCardNo;
            return information;
        }
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getIdentityCardNo() {
        return identityCardNo;
    }

    public void setIdentityCardNo(String identityCardNo) {
        this.identityCardNo = identityCardNo;
    }

    @Override
    public String toString() {
        return "Information{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", position='" + position + '\'' +
                ", startDate='" + startDate + '\'' +
                ", identityCardNo='" + identityCardNo + '\'' +
                '}';
    }
}
