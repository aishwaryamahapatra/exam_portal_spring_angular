package com.exam.ExamServer.service.impl;

import com.exam.ExamServer.entity.User;
import com.exam.ExamServer.entity.UserRole;
import com.exam.ExamServer.repo.RoleRepository;
import com.exam.ExamServer.repo.UserRepository;
import com.exam.ExamServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    //CREATING USERS
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User local = this.userRepository.findByUsername(user.getUsername());
        if(local!=null){
            System.out.println("This username already exists!");
            throw new Exception("User Already Present!");
        }
        else{
            for (UserRole ur: userRoles){
                this.roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local=this.userRepository.save(user);
        }

        return local;
    }

    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUserById(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

}
