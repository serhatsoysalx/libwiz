package com.libwiz.libwiz.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 50)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 50)
    private String lastName;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(min = 6, max = 100)
    private String password;

    @Size(max = 50)
    @Column(unique = true)
    private String username;

    @NotBlank
    private boolean status;

    @NotBlank
    private boolean deleted;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserProfile userProfile;

    public User() {
    }

    public User(Long id, String firstName, String lastName, String email, String password, String username, boolean status, boolean deleted, UserProfile userProfile) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.username = username;
        this.status = status;
        this.deleted = deleted;
        this.userProfile = userProfile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank @Size(min = 2, max = 50) String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank @Size(min = 2, max = 50) String firstName) {
        this.firstName = firstName;
    }

    public @NotBlank @Size(min = 2, max = 50) String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank @Size(min = 2, max = 50) String lastName) {
        this.lastName = lastName;
    }

    public @NotBlank @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @Email String email) {
        this.email = email;
    }

    public @NotBlank @Size(min = 6, max = 100) String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank @Size(min = 6, max = 100) String password) {
        this.password = password;
    }

    public @Size(max = 50) String getUsername() {
        return username;
    }

    public void setUsername(@Size(max = 50) String username) {
        this.username = username;
    }

    @NotBlank
    public boolean isStatus() {
        return status;
    }

    public void setStatus(@NotBlank boolean status) {
        this.status = status;
    }

    @NotBlank
    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(@NotBlank boolean deleted) {
        this.deleted = deleted;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}
