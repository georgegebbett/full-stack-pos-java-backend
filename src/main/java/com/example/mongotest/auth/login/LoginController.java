package com.example.mongotest.auth.login;

import com.example.mongotest.auth.user.User;
import com.example.mongotest.auth.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    UserRepository userRepo;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    Boolean checkLogin(@RequestBody Login loginData) {
        String username = loginData.getUsername();
        if (userRepo.existsUserByUsername(username)) {
            User foundUser = userRepo.findByUsername(username);
            return foundUser.checkPassword(loginData.getPassword());
        } else {
            return false;
        }
    }

}
