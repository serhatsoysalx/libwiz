package com.libwiz.libwiz.util.exception.usercontrollerexceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}