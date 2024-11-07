package com.libwiz.libwiz.controller;

import com.libwiz.libwiz.dto.LoginRequestDto;
import com.libwiz.libwiz.util.exception.usercontrollerexceptions.UserNotFoundException;
import com.libwiz.libwiz.util.auth.TokenManager;
import com.libwiz.libwiz.util.constants.LoginErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword()));
            return new ResponseEntity<>(tokenManager.generateToken(loginRequestDto.getUsername()), HttpStatus.CREATED);
        } catch (Exception e) {
            logger.debug(e.getMessage());
            throw new UserNotFoundException(LoginErrorMessage.INVALID_CREDENTIALS);
        }
    }
}
