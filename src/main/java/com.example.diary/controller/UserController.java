package com.example.diary.controller;

import com.example.diary.model.User;
import com.example.diary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "list-users";
    }

    @GetMapping("/users/{id}")
    public String getUserById(Model model, @PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            throw new EntityNotFoundException("User not found with id " + id);
        }
        model.addAttribute("user", user);
        return "user-details";
    }

    // Other methods for creating, updating, and deleting users...
}
