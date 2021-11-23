package com.registerservice.service;

import com.registerservice.entity.User;
import com.registerservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {

    public User save_user(User user);
    public User fetch_user_by_email(String email);
    public User fetch_user_by_email_and_password(String email, String password);
}
