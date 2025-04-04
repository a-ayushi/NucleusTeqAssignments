package com.HR.portal.controller;

import com.HR.portal.model.User;
import com.HR.portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/user")
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = "http://localhost:63342")
public class UserController {
    @Autowired
    private UserService userService;

    //1. API for register
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        userService.registerUser(user);
        return ResponseEntity.ok("Registered successfully");
    }

    //2.Api to login
    @PostMapping("/login")
    public ResponseEntity<Map<String,Object>> login(@RequestBody User user){
        Map<String, Object> response = userService.login(user); // created a map which will have multiple pieces of info in single response
      return ResponseEntity.ok(response);
    }

}
