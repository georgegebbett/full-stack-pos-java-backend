package com.example.mongotest.auth.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document("users")
public class User {

    @Id
    private String id;
    private String name;
    private String username;
    private String password;
    private String[] roles;

    public User(String name, String username, String password, String[] roles) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public String[] getRoles() {
        return roles;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Boolean checkPassword(String passwordToCheck) {
        return Objects.equals(passwordToCheck, password);
    }
}
