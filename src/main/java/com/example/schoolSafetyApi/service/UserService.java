package com.example.schoolSafetyApi.service;

import com.example.schoolSafetyApi.model.User;
import com.example.schoolSafetyApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public String saveUser(User user) {
        Boolean checkUser = userRepository.existsByEmail(user.getEmail());
        if (checkUser) {
            return "User with this email already exists.";
        } else {
            userRepository.save(user);
            return "User saved successfully.";
        }
    }
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public List<User> getUsersByProvince(String province) {
        return userRepository.findByProvince(province);
    }
    
    public boolean checkUserExists(String email) {
        return userRepository.existsByEmail(email);
    }
}
