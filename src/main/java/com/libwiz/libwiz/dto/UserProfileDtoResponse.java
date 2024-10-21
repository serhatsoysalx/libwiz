package com.libwiz.libwiz.dto;

import com.libwiz.libwiz.entity.User;

import java.util.Date;

public class UserProfileDtoResponse {

    private Long id;

    private String phoneNumber;

    private Date dateOfBirth;

    private String gender;

    private String address;

    private String profilePicture;

    private String about;

    private boolean termsAccepted;

    private boolean privacyPolicyAccepted;

    private boolean delete;

    private User user;

    public UserProfileDtoResponse() {
    }

    public UserProfileDtoResponse(User user, boolean delete, boolean privacyPolicyAccepted, boolean termsAccepted, String about, String profilePicture, String address, String gender, Date dateOfBirth, String phoneNumber, Long id) {
        this.user = user;
        this.delete = delete;
        this.privacyPolicyAccepted = privacyPolicyAccepted;
        this.termsAccepted = termsAccepted;
        this.about = about;
        this.profilePicture = profilePicture;
        this.address = address;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public boolean isTermsAccepted() {
        return termsAccepted;
    }

    public void setTermsAccepted(boolean termsAccepted) {
        this.termsAccepted = termsAccepted;
    }

    public boolean isPrivacyPolicyAccepted() {
        return privacyPolicyAccepted;
    }

    public void setPrivacyPolicyAccepted(boolean privacyPolicyAccepted) {
        this.privacyPolicyAccepted = privacyPolicyAccepted;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserProfileDtoResponse{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", id=" + id +
                '}';
    }

}
