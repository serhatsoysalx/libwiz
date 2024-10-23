package com.libwiz.libwiz.aop.service;

import com.libwiz.libwiz.aop.entity.UserRegistrationInfo;
import com.libwiz.libwiz.aop.repository.UserRegistrationInfoRepository;
import com.libwiz.libwiz.dto.UserDtoRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceAop {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceAop.class);

    private final HttpServletRequest request;

    private UserRegistrationInfoRepository userRegistrationInfoRepository;

    public UserServiceAop(HttpServletRequest request) {
        this.request = request;
    }

    public void setUserRegistrationInfoRepository(UserRegistrationInfoRepository userRegistrationInfoRepository) {
        this.userRegistrationInfoRepository = userRegistrationInfoRepository;
    }

    public UserRegistrationInfo afterCreateUserAspect(UserDtoRequest userDtoRequest) {
        UserRegistrationInfo userRegistrationInfo = new UserRegistrationInfo();

        userRegistrationInfo.setRegisterUserId(userDtoRequest.getId());
        userRegistrationInfo.setUsername(userDtoRequest.getUsername());
        userRegistrationInfo.setEmail(userDtoRequest.getEmail());
        userRegistrationInfo.setIpAddress(getClientIp(request));
        userRegistrationInfo.setRegistrationDate(LocalDateTime.now());
        userRegistrationInfo.setPort(String.valueOf(request.getRemotePort()));

        logger.info("Creating IP: {}", userRegistrationInfo.getIpAddress());

        userRegistrationInfo = userRegistrationInfoRepository.save(userRegistrationInfo);
        return userRegistrationInfo;
    }

    private String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
