package com.appsdeveloperblog.estore.service;

import model.User;

import java.util.UUID;

public class UserServiceImpl implements UserService {

    @Override
    public User createUser(String firstName, String lastName, String email, String password) {

        if (firstName == null || firstName.trim().length() == 0) {
            throw new IllegalArgumentException("User's first name is empty");
        }

        return new User(firstName, lastName, email, UUID.randomUUID().toString());
    }

    public void demoMethod() {
        System.out.println("demo method");
    }


}
