package com.libwiz.libwiz.dto;

public class UserDtoRequest {

    private Long id;

    private String email;

    private String password;

    private String username;

    private boolean status;

    private boolean deleted;

    public UserDtoRequest() {
    }

    public UserDtoRequest(Long id, String email, String password, String username, boolean status, boolean deleted) {
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

    @Override
    public String toString() {
        return "UserDtoRequest{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
