package com.libwiz.libwiz.service;

import com.libwiz.libwiz.dto.UserProfileDtoRequest;
import com.libwiz.libwiz.dto.UserProfileDtoResponse;
import com.libwiz.libwiz.entity.UserProfile;
import com.libwiz.libwiz.repository.UserProfileRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UserProfileDtoResponse createUserProfile(UserProfileDtoRequest userProfileDtoRequest) {
        final UserProfile userProfile = convertToEntity(userProfileDtoRequest);
        return convertToDtoResponse(userProfileRepository.save(userProfile));
    }

    public UserProfileDtoResponse getUserProfileById(Long id) {
        return convertToDtoResponse(userProfileRepository.findById(id).orElse(null));
    }

    public Iterable<UserProfileDtoResponse> getAllUserProfiles() {
        final List<UserProfile> listOfUserProfile = userProfileRepository.findAll();
        List<UserProfileDtoResponse> listOfUserProfileDtoResponse = new ArrayList<>();
        listOfUserProfile.forEach(userProfile -> {
            listOfUserProfileDtoResponse.add(convertToDtoResponse(userProfile));
        });
        return listOfUserProfileDtoResponse;
    }

    public UserProfileDtoResponse updateUserProfile(Long id, UserProfileDtoRequest userProfileDtoRequest) {
        if (userProfileRepository.existsById(id)) {
            userProfileDtoRequest.setId(id);
            return convertToDtoResponse(userProfileRepository.save(convertToEntity(userProfileDtoRequest)));
        }
        return null;
    }

    public boolean deleteUserProfile(Long id) {
        if (userProfileRepository.existsById(id)) {
            final UserProfile userProfile = userProfileRepository.findById(id).orElseThrow();
            userProfile.setDelete(Boolean.TRUE);
            userProfileRepository.save(userProfile);
            return true;
        }
        return false;
    }

    public UserProfile convertToEntity(UserProfileDtoRequest userProfileDtoRequest) {
        return modelMapper.map(userProfileDtoRequest, UserProfile.class);
    }

    public UserProfileDtoResponse convertToDtoResponse(UserProfile userProfile) {
        return modelMapper.map(userProfile, UserProfileDtoResponse.class);
    }
}
