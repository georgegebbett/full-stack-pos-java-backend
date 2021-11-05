package com.example.mongotest.auth.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User testUser = new User("test user", "test", "test", new String[]{"role"});

    @Test
    @DisplayName("Password check returns true for good value")
    void checkGoodPassword() {
        assertTrue(testUser.checkPassword("test"));
    }

    @Test
    @DisplayName("Password check returns false for bad value")
    void checkBadPassword() {
        assertFalse(testUser.checkPassword("test123"));
    }
}