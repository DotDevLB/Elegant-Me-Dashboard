package com.elegant.me.server.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elegant.me.server.Models.User;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    public boolean authenticateUser(String username, String password) {
        // Fetch user by username
        User user = userService.getUserByUsername(username);
        
        // Check if user exists and if the password matches
        return user != null && user.getPassword().equals(password)&& user.isRole();
    }
}

