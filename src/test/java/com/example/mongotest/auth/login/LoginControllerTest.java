package com.example.mongotest.auth.login;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class LoginControllerTest {

    @Autowired
    LoginController loginController;

    @Test
    @DisplayName("Login with good details returns true")
    void checkSuccessfulLogin() {
        Login goodDetails = new Login("george", "test");
        assertTrue(loginController.checkLogin(goodDetails));
    }

    @Test
    @DisplayName("Login with bad username returns false")
    void checkBadUserLogin() {
        Login badUser = new Login("ThisUserDoesNotExist", "test");
        assertFalse(loginController.checkLogin(badUser));
    }

    @Test
    @DisplayName("Login with bad password returns false")
    void checkBadPassLogin() {
        Login badPass = new Login("george", "test123");
        assertFalse(loginController.checkLogin(badPass));
    }
}