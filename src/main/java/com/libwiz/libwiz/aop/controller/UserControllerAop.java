package com.libwiz.libwiz.aop.controller;

import com.libwiz.libwiz.aop.entity.UserRegistrationInfo;
import com.libwiz.libwiz.aop.service.UserServiceAop;
import com.libwiz.libwiz.dto.UserDtoRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserControllerAop {

    @Autowired
    private UserServiceAop userServiceAop;

    private static final Logger logger = LoggerFactory.getLogger(UserControllerAop.class);

    @Before("execution(* com.libwiz.libwiz.controller.UserController.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Entering method: {}", joinPoint.getSignature().getName());
        logger.info("With arguments: {}", joinPoint.getArgs());
    }

    @After("execution(* com.libwiz.libwiz.controller.UserController.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("Exiting method: {}", joinPoint.getSignature().getName());
    }

    @Before("execution(* com.libwiz.libwiz.controller.UserController.createUser()))")
    public void beforeCreateUserAspect(JoinPoint joinPoint) {
        logger.info("User creating. Entering method: {}", joinPoint.getSignature().getName());
    }

    @After("execution(* com.libwiz.libwiz.controller.UserController.createUser()) && args(userDtoRequest)")
    public void afterUserSave(UserDtoRequest userDtoRequest) {
        userServiceAop.afterCreateUserAspect(userDtoRequest);
    }

    @AfterReturning(pointcut = "execution(* com.libwiz.libwiz.service.UserService.createUser(..))", returning = "userRegistrationInfo")
    public void logAfterReturning(UserRegistrationInfo userRegistrationInfo) {
        logger.info("User created successfully: {}", userRegistrationInfo);
    }
}
