package com.libwiz.libwiz.aop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "userregisterinfo")
public class UserRegistrationInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private Long registerUserId;

    @Size(max = 50)
    @Column(unique = true)
    private String username;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    private LocalDateTime registrationDate;

    @NotBlank
    private String ipAddress;

    @NotBlank
    private String port;

    public UserRegistrationInfo() {
    }

    public UserRegistrationInfo(Long id, Long registerUserId, String username, String email, LocalDateTime registrationDate, String ipAddress, String port) {
        this.id = id;
        this.registerUserId = registerUserId;
        this.username = username;
        this.email = email;
        this.registrationDate = registrationDate;
        this.ipAddress = ipAddress;
        this.port = port;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRegisterUserId() {
        return registerUserId;
    }

    public void setRegisterUserId(Long registerUserId) {
        this.registerUserId = registerUserId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
