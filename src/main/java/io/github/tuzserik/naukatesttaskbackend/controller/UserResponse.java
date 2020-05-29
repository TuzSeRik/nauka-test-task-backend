package io.github.tuzserik.naukatesttaskbackend.controller;

import io.github.tuzserik.naukatesttaskbackend.model.User;

import java.util.List;

public class UserResponse {
    int status;
    long id;
    String message;
    User user;
    List<User> array;

    public UserResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public UserResponse(int status, long id) {
        this.status = status;
        this.id = id;
    }

    public UserResponse(int status, User user) {
        this.status = status;
        this.user = user;
    }

    public UserResponse(int status, List<User> array) {
        this.status = status;
        this.array = array;
    }
}
