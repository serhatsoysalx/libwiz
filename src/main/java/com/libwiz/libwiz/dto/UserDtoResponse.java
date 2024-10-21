package com.libwiz.libwiz.dto;

import com.libwiz.libwiz.entity.UserProfile;

public class UserDtoResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String username;

    private boolean status;

    private boolean delete;

    private UserProfile userProfile;

    public UserDtoResponse() {
    }

    public UserDtoResponse(Long id, String firstName, String lastName, String email, String password, String username, boolean status, boolean delete, UserProfile userProfile) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.username = username;
        this.status = status;
        this.delete = delete;
        this.userProfile = userProfile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    @Override
    public String toString() {
        return "UserDtoResponse{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
