package com.appsdeveloperblog.estore.service;

import model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserServiceTest {
    UserService userService;
    String firstName;
    String lastName;
    String email;
    String password;

    @BeforeEach
    void init() {
        userService = new UserServiceImpl();
        firstName = "soni";
        lastName = "son";
        email = "soni@test.com";
        password = "12345";
    }

    @DisplayName("user object created")
    @Test
    void testCreateUser_whenUserDetailsProvided_returnsUserObject() {
        User user = userService.createUser(firstName, lastName, email, password);

        assertNotNull(user);
        assertEquals(firstName, user.getFirstName());
        assertEquals(lastName, user.getLastName());
        assertEquals(email, user.getEmail());
        assertNotNull(user.getId());
    }

    @DisplayName("user first Name missing")
    @Test
    void testCreateUser_whenFirstNameEmpty_throwsException() {
        String firstName = "";
        String expectedExceptionMessage = "User's first name is empty";

        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(firstName, lastName, email, password);
        });

        assertEquals(expectedExceptionMessage, thrown.getMessage());
    }

}
