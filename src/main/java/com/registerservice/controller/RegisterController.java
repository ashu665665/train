package com.registerservice.controller;

import com.registerservice.entity.User;
import com.registerservice.service.SequenceGeneratorService;
import com.registerservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

import static com.registerservice.entity.User.SEQUENCE_NAME;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class RegisterController {

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private SequenceGeneratorService service;

    @PostMapping("/register")
    public User register_user(@RequestBody User user) throws Exception {

        user.setUser_id(service.getSequenceNumber(SEQUENCE_NAME));
//        user.setUserPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        return this.userService.save_user(user);
//        String temp_user_mail = user.getUserEmail();
//        if(temp_user_mail !=null && !"".equals(temp_user_mail)){
//            User new_user_obj = userService.fetch_user_by_email(temp_user_mail);
//            if(new_user_obj != null){
//                throw new Exception("User with same email exists, please Login!!");
//            }
//        }
//        user.setUser_id(service.getSequenceNumber(SEQUENCE_NAME));
//        return "a";
    }

    @PostMapping("/login")
    public User login_user(@RequestBody String mail) throws Exception {
//        String temp_user_mail = user.getUserEmail();
//        String temp_user_password = user.getUserPassword();
        User user_object = null;
        if(mail != null){
            User user_obj = userService.fetch_user_by_email(mail);
            if(user_obj == null){
                throw new Exception("Account does not Exists, please register");
            }
//            user_object = userService.fetch_user_by_email_and_password(temp_user_mail, temp_user_password);
            user_object = userService.fetch_user_by_email(mail);
            if(user_object == null){
                throw new Exception("Invalid Creds");
            }
        }
        return user_object;
    }
}
