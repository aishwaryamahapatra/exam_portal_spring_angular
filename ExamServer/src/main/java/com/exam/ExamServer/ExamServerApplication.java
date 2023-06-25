package com.exam.ExamServer;

import com.exam.ExamServer.entity.Role;
import com.exam.ExamServer.entity.User;
import com.exam.ExamServer.entity.UserRole;
import com.exam.ExamServer.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamServerApplication implements CommandLineRunner{

	@Autowired
	private UserServiceImpl userServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(ExamServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		User user = new User("mahapata", "Aishwarya", "Mahapatra",
//				"abc@gmail.com", "abc.png", true,"abc");
//
//		Role role = new Role(44L, "ADMIN");
//
//		Set<UserRole> userRoleSet = new HashSet<>();
//
//		UserRole userRole = new UserRole(user, role);
//
//		userRoleSet.add(userRole);
//
//		User user1 = this.userServiceImpl.createUser(user, userRoleSet);
//
//		System.out.println(user1);
	}
}
