package com.cbt.pojos;

public class Member {
    private String stateId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String homeAddressStreet1;
    private String homeAddressStreet2;
    private String homeAddressCity;
    private String homeAddressState;
    private int homeAddressZip;
    private String mailingAddressStreet1;
    private String mailingAddressStreet2;
    private String mailingAddressCity;
    private String mailingAddressState;
    private int mailingAddressZip;
    private String phoneHome;
    private String phoneCell;
    private String email1;
    private String email2;
    private String dateOfBirth;
    private String gender;
    private String countyOfResidence;
    private boolean activeCase;

    public Member(String stateId, String firstName, String middleName, String lastName, String homeAddressStreet1, String homeAddressStreet2, String homeAddressCity, String homeAddressState, int homeAddressZip, String mailingAddressStreet1, String mailingAddressStreet2, String mailingAddressCity, String mailingAddressState, int mailingAddressZip, String phoneHome, String phoneCell, String email1, String email2, String dateOfBirth, String gender, String countyOfResidence, boolean activeCase) {
        this.stateId = stateId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.homeAddressStreet1 = homeAddressStreet1;
        this.homeAddressStreet2 = homeAddressStreet2;
        this.homeAddressCity = homeAddressCity;
        this.homeAddressState = homeAddressState;
        this.homeAddressZip = homeAddressZip;
        this.mailingAddressStreet1 = mailingAddressStreet1;
        this.mailingAddressStreet2 = mailingAddressStreet2;
        this.mailingAddressCity = mailingAddressCity;
        this.mailingAddressState = mailingAddressState;
        this.mailingAddressZip = mailingAddressZip;
        this.phoneHome = phoneHome;
        this.phoneCell = phoneCell;
        this.email1 = email1;
        this.email2 = email2;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.countyOfResidence = countyOfResidence;
        this.activeCase = activeCase;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHomeAddressStreet1() {
        return homeAddressStreet1;
    }

    public void setHomeAddressStreet1(String homeAddressStreet1) {
        this.homeAddressStreet1 = homeAddressStreet1;
    }

    public String getHomeAddressStreet2() {
        return homeAddressStreet2;
    }

    public void setHomeAddressStreet2(String homeAddressStreet2) {
        this.homeAddressStreet2 = homeAddressStreet2;
    }

    public String getHomeAddressCity() {
        return homeAddressCity;
    }

    public void setHomeAddressCity(String homeAddressCity) {
        this.homeAddressCity = homeAddressCity;
    }

    public String getHomeAddressState() {
        return homeAddressState;
    }

    public void setHomeAddressState(String homeAddressState) {
        this.homeAddressState = homeAddressState;
    }

    public int getHomeAddressZip() {
        return homeAddressZip;
    }

    public void setHomeAddressZip(int homeAddressZip) {
        this.homeAddressZip = homeAddressZip;
    }

    public String getMailingAddressStreet1() {
        return mailingAddressStreet1;
    }

    public void setMailingAddressStreet1(String mailingAddressStreet1) {
        this.mailingAddressStreet1 = mailingAddressStreet1;
    }

    public String getMailingAddressStreet2() {
        return mailingAddressStreet2;
    }

    public void setMailingAddressStreet2(String mailingAddressStreet2) {
        this.mailingAddressStreet2 = mailingAddressStreet2;
    }

    public String getMailingAddressCity() {
        return mailingAddressCity;
    }

    public void setMailingAddressCity(String mailingAddressCity) {
        this.mailingAddressCity = mailingAddressCity;
    }

    public String getMailingAddressState() {
        return mailingAddressState;
    }

    public void setMailingAddressState(String mailingAddressState) {
        this.mailingAddressState = mailingAddressState;
    }

    public int getMailingAddressZip() {
        return mailingAddressZip;
    }

    public void setMailingAddressZip(int mailingAddressZip) {
        this.mailingAddressZip = mailingAddressZip;
    }

    public String getPhoneHome() {
        return phoneHome;
    }

    public void setPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
    }

    public String getPhoneCell() {
        return phoneCell;
    }

    public void setPhoneCell(String phoneCell) {
        this.phoneCell = phoneCell;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountyOfResidence() {
        return countyOfResidence;
    }

    public void setCountyOfResidence(String countyOfResidence) {
        this.countyOfResidence = countyOfResidence;
    }

    public boolean isActiveCase() {
        return activeCase;
    }

    public void setActiveCase(boolean activeCase) {
        this.activeCase = activeCase;
    }

    @Override
    public String toString() {
        return "Member{" +
                "stateId='" + stateId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email1='" + email1 + '\'' +
                ", activeCase=" + activeCase +
                '}';
    }
}
