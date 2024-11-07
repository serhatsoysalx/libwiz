package com.libwiz.libwiz.util.swagger.model;

import com.libwiz.libwiz.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(defaultValue = "User Profile Model Request", description = "User Profile Request model Json Model")
public class UserProfileRequestModelAOP {

    @Schema(nullable = true, defaultValue = "User Profile id")
    private Long id;

    @Schema(nullable = true, defaultValue = "User Profile informations")
    private User user;

    public UserProfileRequestModelAOP() {
    }

    public UserProfileRequestModelAOP(Long id, User user) {
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
}
