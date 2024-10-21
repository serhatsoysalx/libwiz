package com.libwiz.libwiz.swagger2.model;


import com.libwiz.libwiz.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Schema(defaultValue = "User Profile Model Response", description = "User Profile Response model Json Model")
public class UserProfileResponseModelAOP {

    @Schema(nullable = true, defaultValue = "User Profile id")
    private Long id;

    @Schema(nullable = true, defaultValue = "User Profile Phone Number")
    private String phoneNumber;

    @Schema(nullable = true, defaultValue = "User Profile Birth Date")
    private Date dateOfBirth;

    @Schema(nullable = true, defaultValue = "User Profile Gender")
    private String gender;

    @Schema(nullable = true, defaultValue = "User Profile Adress")
    private String address;

    @Schema(nullable = true, defaultValue = "User Profile Profile Picture")
    private String profilePicture;

    @Schema(nullable = true, defaultValue = "User Profile About")
    private String about;

    @Schema(nullable = true, defaultValue = "User Profile Terms Accepted information")
    private boolean termsAccepted;

    @Schema(nullable = true, defaultValue = "User Profile Privacy Policy Accepted informations")
    private boolean privacyPolicyAccepted;

    @Schema(nullable = true, defaultValue = "User Profile delete information")
    private boolean delete;

    @Schema(nullable = true, defaultValue = "User Profile informations")
    private User user;

    public UserProfileResponseModelAOP() {
    }

    public UserProfileResponseModelAOP(Long id, String phoneNumber, Date dateOfBirth, String gender, String address, String profilePicture, String about, boolean termsAccepted, boolean privacyPolicyAccepted, boolean delete, User user) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.profilePicture = profilePicture;
        this.about = about;
        this.termsAccepted = termsAccepted;
        this.privacyPolicyAccepted = privacyPolicyAccepted;
        this.delete = delete;
        this.user = user;
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
}
