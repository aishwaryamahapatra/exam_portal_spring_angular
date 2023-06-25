package com.exam.ExamServer.controller;

import com.exam.ExamServer.entity.Role;
import com.exam.ExamServer.entity.User;
import com.exam.ExamServer.entity.UserRole;
import com.exam.ExamServer.service.UserService;
import com.exam.ExamServer.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
        user.setProfile("default.png");
        Role role = new Role(45L, "NORMAL");
        UserRole userRole = new UserRole(user, role);

        Set<UserRole> userRoleSet = new HashSet<>();
        userRoleSet.add(userRole);

        return this.userService.createUser(user, userRoleSet);
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return this.userService.getUser(username);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        this.userService.deleteUserById(userId);
    }

    @PutMapping("/")
    public void updateUser(@RequestBody User user){
        this.userService.saveUser(user);
    }
}
