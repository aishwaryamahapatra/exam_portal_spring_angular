package com.exam.ExamServer.service;

import com.exam.ExamServer.entity.User;
import com.exam.ExamServer.entity.UserRole;

import java.util.Set;

public interface UserService {
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    public User getUser(String username);

    public void deleteUserById(Long id);

    public void saveUser(User user);
}
