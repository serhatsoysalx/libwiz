package com.libwiz.libwiz.util.auth;

import com.libwiz.libwiz.service.UserLoginService;
import com.libwiz.libwiz.util.constants.LoginErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserLoginService userLoginService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return new User(username, userLoginService.exists(username).getPassword(), new ArrayList<>());
        } catch (Exception e) {
            throw new UsernameNotFoundException(LoginErrorMessage.AUTHENTICATION_FAILED);
        }
    }
}
