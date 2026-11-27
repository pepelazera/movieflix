package com.movieflix.exceptions;

public class UsernameOrPasswordInvalid extends RuntimeException {

    public UsernameOrPasswordInvalid(String message) {
        super(message);
    }
}
