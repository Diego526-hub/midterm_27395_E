package com.example.schoolSafetyApi.controller;

import com.example.schoolSafetyApi.model.User;
import com.example.schoolSafetyApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        String response = userService.saveUser(user);
        if (response.contains("already exists")) {
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
    
    @GetMapping("/province/{province}")
    public ResponseEntity<List<User>> getUsersByProvince(@PathVariable String province) {
        return new ResponseEntity<>(userService.getUsersByProvince(province), HttpStatus.OK);
    }
    
    @GetMapping("/exists/{email}")
    public ResponseEntity<Boolean> checkUserExists(@PathVariable String email) {
        return new ResponseEntity<>(userService.checkUserExists(email), HttpStatus.OK);
    }
}
