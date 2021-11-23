package com.registerservice.controller;

import com.registerservice.entity.User;
import com.registerservice.service.SequenceGeneratorService;
import com.registerservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.registerservice.entity.User.SEQUENCE_NAME;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200/login")
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private SequenceGeneratorService service;

    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:4200")
    public User register_user(@RequestBody User user) throws Exception {
        String temp_user_mail = user.getUserEmail();
        if(temp_user_mail !=null && !"".equals(temp_user_mail)){
            User new_user_obj = userService.fetch_user_by_email(temp_user_mail);
            if(new_user_obj != null){
                throw new Exception("User with same email exists, please Login!!");
            }
        }
        user.setUser_id(service.getSequenceNumber(SEQUENCE_NAME));
        return userService.save_user(user);
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public User login_user(@RequestBody User user) throws Exception {
        String temp_user_mail = user.getUserEmail();
        String temp_user_password = user.getUserPassword();
        User user_object = null;
        if(temp_user_mail != null && temp_user_password != null){
            User user_obj = userService.fetch_user_by_email(temp_user_mail);
            if(user_obj == null){
                throw new Exception("Account does not Exists, please register");
            }
            user_object = userService.fetch_user_by_email_and_password(temp_user_mail, temp_user_password);
            if(user_object == null){
                throw new Exception("Invalid Creds");
            }
        }
        return user_object;
    }
}
