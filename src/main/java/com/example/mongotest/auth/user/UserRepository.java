package com.example.mongotest.auth.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);

    Boolean existsUserByUsername(String username);

    @Query(fields = "{'username': 1, 'name': 1, 'roles': 1}")
    Optional<User> findUserById(String id);

    long count();

}
