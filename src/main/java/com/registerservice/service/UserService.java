package com.registerservice.service;

import com.registerservice.entity.User;

import java.util.Set;

public interface UserService {

    public User save_user(User user) throws Exception;
    public User fetch_user_by_email(String email);
    public User fetch_user_by_email_and_password(String email, String password);
}
