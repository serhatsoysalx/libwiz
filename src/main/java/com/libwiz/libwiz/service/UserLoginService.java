package com.libwiz.libwiz.service;

import com.libwiz.libwiz.dto.LoginRequestDto;
import com.libwiz.libwiz.entity.User;
import com.libwiz.libwiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final String USER_PREFIX = "user:";

    public LoginRequestDto exists(String username) {
        final User user = getUserWithUsername(username);
        return new LoginRequestDto(user.getUsername(), user.getPassword());
    }

    private User getUserWithUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow();
    }


    public void saveUser(String username, String token) {
        redisTemplate.opsForValue().set(USER_PREFIX + username, token);
    }

    public String getUser(String username) {
        return (String) redisTemplate.opsForValue().get(USER_PREFIX + username);
    }

    public void deleteUser(String username) {
        redisTemplate.delete(USER_PREFIX + username);
    }
}
