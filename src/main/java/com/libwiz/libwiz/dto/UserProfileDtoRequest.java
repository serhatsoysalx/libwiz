package com.libwiz.libwiz.dto;

import com.libwiz.libwiz.entity.User;

public class UserProfileDtoRequest {

    private Long id;

    private User user;

    public UserProfileDtoRequest() {
    }

    public UserProfileDtoRequest(Long id, User user) {
        this.id = id;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserProfileDtoRequest{" +
                "id=" + id +
                '}';
    }
}
