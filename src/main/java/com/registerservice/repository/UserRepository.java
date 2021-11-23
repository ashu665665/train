package com.registerservice.repository;

import com.registerservice.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, Long> {

    User findByUserEmail(String email);
    User findByUserEmailAndUserPassword(String email, String password);

}
