package com.libwiz.libwiz.swagger2.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(defaultValue = "User Model Request", description = "User Request model Json Model")
public class UserRequestModelAOP {

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
    private boolean deleted;

    public UserRequestModelAOP() {
    }

    public UserRequestModelAOP(Long id, String email, String password, String username, boolean status, boolean deleted) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.status = status;
        this.deleted = deleted;
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
