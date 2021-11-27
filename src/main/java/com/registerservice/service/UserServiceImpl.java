package com.registerservice.service;

import com.registerservice.entity.User;
import com.registerservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    //saving user
    public User save_user(User user) throws Exception {
        User local = this.userRepository.findByUserEmail(user.getUserEmail());
        if(local != null){
            System.out.println("User already present");
            throw new Exception("User already present");
        }
        else{
            //user create
            local = this.userRepository.save(user);
        }
        return local;

    }

    public User fetch_user_by_email(String email) {
        return userRepository.findByUserEmail(email);
    }

    public User fetch_user_by_email_and_password(String email, String password) {
        return userRepository.findByUserEmailAndUserPassword(email, password);
    }

}
