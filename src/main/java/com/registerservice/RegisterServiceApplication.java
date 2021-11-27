package com.registerservice;

import com.registerservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RegisterServiceApplication{

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(RegisterServiceApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("coding");
//
//		User user = new User();
//		user.setUserName("a");
//		user.setUserEmail("a");
//		user.setUserPassword("a");
//
//		Role role1 = new Role();
//		role1.setRoleId(44L);
//		role1.setRoleName("ADMIN");
//
//		Set<UserRole> userRoleSet = new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//
//		userRoleSet.add(userRole);
//
//		User user1 = this.userService.save_user(user, userRoleSet);
//		System.out.println(user1.getUserName());
//
//
//
//	}
}

