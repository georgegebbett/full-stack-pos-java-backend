package com.example.mongotest.auth.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepo;

    @GetMapping("/api/users")
    public List<User> users() {
        return userRepo.findAll();
    }

    @GetMapping("/api/users/{userId}")
    public Optional<User> oneUser(@PathVariable String userId) {
        return userRepo.findById(userId);
//        return userRepo.findUserById(userId);
    }

    @PostMapping(path = "/api/users",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public User createUser(@RequestBody User userData) {
        return userRepo.insert(userData);
    }

    @DeleteMapping("/api/users/{userId}")
    public String deleteUser (@PathVariable String userId) {
        System.out.println("Deleting user " + userId);
        if (oneUser(userId).isPresent()) {
            userRepo.deleteById(userId);
            return "User deleted";
        } else {
            System.out.println("No such user");
            return "No user to delete";
        }
    }

}
