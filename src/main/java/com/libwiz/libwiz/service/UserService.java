package com.libwiz.libwiz.service;

import com.libwiz.libwiz.dto.UserDtoRequest;
import com.libwiz.libwiz.dto.UserDtoResponse;
import com.libwiz.libwiz.entity.User;
import com.libwiz.libwiz.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public UserDtoResponse createUser(UserDtoRequest userDtoRequest) {
        final User user = convertToEntity(userDtoRequest);
        return convertToDtoResponse(userRepository.save(user));
    }

    public UserDtoResponse getUserById(Long id) {
        return convertToDtoResponse(userRepository.findById(id).orElse(null));
    }

    public List<UserDtoResponse> getAllUsers() {
        final List<User> listOfUser = userRepository.findAll();
        List<UserDtoResponse> listOfUserDtoResponses = new ArrayList<>();
        listOfUser.forEach(user -> {
            listOfUserDtoResponses.add(convertToDtoResponse(user));
        });
        return listOfUserDtoResponses;
    }

    public UserDtoResponse updateUser(Long id, UserDtoRequest userDtoRequest) {
        if (userRepository.existsById(id)) {
            userDtoRequest.setId(id);
            final User user = userRepository.save(convertToEntity(userDtoRequest));
            return convertToDtoResponse(user);
        }
        return null;
    }

    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            final User user = userRepository.findById(id).orElseThrow();
            user.setDeleted(Boolean.TRUE);
            userProfileService.deleteUserProfile(user.getUserProfile().getId());
            userRepository.save(user);
            return true;
        }
        return false;
    }


    public User convertToEntity(UserDtoRequest userDtoRequest) {
        return modelMapper.map(userDtoRequest, User.class);
    }

    public UserDtoResponse convertToDtoResponse(User user) {
        return modelMapper.map(user, UserDtoResponse.class);
    }
}
