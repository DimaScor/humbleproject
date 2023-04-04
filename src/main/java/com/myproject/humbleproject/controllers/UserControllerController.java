package com.myproject.humbleproject.controllers;

import com.myproject.humbleproject.entities.User;
import org.springframework.web.bind.annotation.*;
import com.myproject.humbleproject.repositories.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/user-profiles")
public class UserControllerController {
    private final UserRepository userProfileRepository;

    public UserControllerController(UserRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @GetMapping
    public List<User> getAllUserProfiles() {
        return userProfileRepository.findAll();
    }

    @PostMapping
    public User createUserProfile(@RequestBody User user) {
        return userProfileRepository.save(user);
    }

}