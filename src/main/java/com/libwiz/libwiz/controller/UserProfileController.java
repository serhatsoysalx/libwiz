package com.libwiz.libwiz.controller;

import com.libwiz.libwiz.dto.UserProfileDtoRequest;
import com.libwiz.libwiz.dto.UserProfileDtoResponse;
import com.libwiz.libwiz.service.UserProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/userprofiles")
@Tag(name = "user-profile api", description = "User Profile api informations")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @PostMapping
    @Operation(description = "Create User Profile")
    public ResponseEntity<UserProfileDtoResponse> createUserProfile(@RequestBody UserProfileDtoRequest userProfileDtoRequest) {
        UserProfileDtoResponse createdProfile = userProfileService.createUserProfile(userProfileDtoRequest);
        return new ResponseEntity<>(createdProfile, HttpStatus.CREATED);
    }

    @GetMapping("/getuserprofile/{id}")
    @Operation(description = "Get User Profile with id")
    public ResponseEntity<UserProfileDtoResponse> getUserProfileById(@PathVariable Long id) {
        UserProfileDtoResponse userProfile = userProfileService.getUserProfileById(id);
        return userProfile != null ? ResponseEntity.ok(userProfile) : ResponseEntity.notFound().build();
    }

    @GetMapping("/getalluserprofile")
    @Operation(description = "Get all user profiles")
    public ResponseEntity<Iterable<UserProfileDtoResponse>> getAllUserProfiles() {
        Iterable<UserProfileDtoResponse> userProfiles = userProfileService.getAllUserProfiles();
        return ResponseEntity.ok(userProfiles);
    }

    @PutMapping("/updateuserprofile/{id}")
    @Operation(description = "update user profile")
    public ResponseEntity<UserProfileDtoResponse> updateUserProfile(@PathVariable Long id, @RequestBody UserProfileDtoRequest userProfileDtoRequest) {
        UserProfileDtoResponse updatedProfile = userProfileService.updateUserProfile(id, userProfileDtoRequest);
        return updatedProfile != null ? ResponseEntity.ok(updatedProfile) : ResponseEntity.notFound().build();
    }

}
