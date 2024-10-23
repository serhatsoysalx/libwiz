package com.libwiz.libwiz.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "user_profiles")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 6, max = 20)
    @Column(unique = true)
    private String phoneNumber;

    private Date dateOfBirth;

    private String gender;

    private String address;

    private String profilePicture;

    private String about;

    private boolean termsAccepted;

    private boolean privacyPolicyAccepted;

    private boolean delete;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    public UserProfile() {
    }

    public UserProfile(Long id, String phoneNumber, Date dateOfBirth, String gender, String address, String profilePicture, String about, boolean termsAccepted, boolean privacyPolicyAccepted, boolean delete, User user) {
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
