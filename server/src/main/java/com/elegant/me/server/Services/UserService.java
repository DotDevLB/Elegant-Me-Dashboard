package com.elegant.me.server.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.elegant.me.server.Models.User;
import com.elegant.me.server.Repos.UserRepository;
import org.springframework.data.domain.Page;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

     public Page<User> getUsersWithPagination(int page) {
        return userRepository.findAll(PageRequest.of(page, 8));
    }
    
    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    
    public User createUser(User user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    
    public User updateUser(Integer userId, User user) {
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setRole(user.isRole());
            existingUser.setPhoneNumber(user.getPhoneNumber());
            existingUser.setUpdatedAt(LocalDateTime.now());
            return userRepository.save(existingUser);
        }
        return null;
    }

    
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


}
