package com.libwiz.libwiz.aop.controller;

import com.libwiz.libwiz.dto.LoginRequestDto;
import com.libwiz.libwiz.service.UserLoginService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginControllerAop {

    @Autowired
    private UserLoginService userLoginService;

    @Around("execution(* com.libwiz.libwiz.controller.LoginController.login())")
    public void addUserSession(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        LoginRequestDto loginRequestDto = (LoginRequestDto) args[0];
        String token = (String) joinPoint.proceed();
        userLoginService.saveUser(loginRequestDto.getUsername(), token);
    }
}
