package com.libwiz.libwiz.util.swagger.model;

import com.libwiz.libwiz.entity.UserProfile;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(defaultValue = "User Model Response", description = "User Response model Json Model")
public class UserResponseModelAOP {

    @Schema(nullable = true, defaultValue = "User id")
    private Long id;

    @Schema(nullable = true, defaultValue = "User email")
    private String email;

    @Schema(nullable = true, defaultValue = "User password")
    private String password;

    @Schema(nullable = true, defaultValue = "User username")
    private String username;

    @Schema(nullable = true, defaultValue = "User status")
    private boolean status;

    @Schema(nullable = true, defaultValue = "User delete status")
    private boolean delete;

    @Schema(nullable = true, defaultValue = "Object of User Profile")
    private UserProfile userProfile;

    public UserResponseModelAOP() {
    }

    public UserResponseModelAOP(Long id, String email, String password, String username, boolean status, boolean delete, UserProfile userProfile) {
        this.id = id;
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
}
