package com.registerservice.service;

import com.registerservice.entity.User;
import com.registerservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    public User save_user(User user){
        return userRepository.save(user);
    }

    public User fetch_user_by_email(String email){
        return userRepository.findByUserEmail(email);
    }

    public User fetch_user_by_email_and_password(String email, String password){
        return userRepository.findByUserEmailAndUserPassword(email,password);
    }

}
