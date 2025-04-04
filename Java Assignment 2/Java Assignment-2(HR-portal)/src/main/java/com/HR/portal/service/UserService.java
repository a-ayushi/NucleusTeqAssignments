package com.HR.portal.service;

import com.HR.portal.model.User;
import com.HR.portal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // used when a new user registers
    //used in user registration APIs
    public User registerUser(User user){
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new RuntimeException("Error:Email is already present");
        }
        return userRepository.save(user);
    }

    //logic for login
    public Map<String, Object> login(User user) {
        Map<String, Object> response = new HashMap<>();
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            User userFromDb = existingUser.get();
            if (userFromDb.getPassword().equals(user.getPassword())) {
                response.put("message", "Login successful!");
                response.put("userId", userFromDb.getId());
            } else {
                response.put("message", "Invalid credentials");
            }
        } else {
            response.put("message", "User not found");
        }
        return response;
    }

    //used during the login to check if email belong to registered user
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
