package com.example.mongotest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MongoTestApplication{

//    @Autowired
//    UserRepository userRepo;

    public static void main(String[] args) {
        SpringApplication.run(MongoTestApplication.class, args);
    }

//    @GetMapping("/api/users")
//    public List<User> users() {
//        return userRepo.findAll();
//    }
//
//    @GetMapping("/api/users/{userId}")
//    public Optional<User> oneUser(@PathVariable String userId) {
//        return userRepo.findById(userId);
//    }

}
