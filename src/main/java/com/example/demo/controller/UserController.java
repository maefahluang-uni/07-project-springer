package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return "welcome";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, @RequestParam String firstname,@RequestParam String lastname,@RequestParam String email,@RequestParam String phone, Model model) {
        User existingUser = userService.findByUsername(username);
        if (existingUser != null) {
            model.addAttribute("error", "Username already exists");
            return "register";
        }

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setFirstname(firstname);
        newUser.setLastname(lastname);
        newUser.setEmail(email);
        newUser.setPhone(phone);


        userService.saveUser(newUser);

        return "redirect:/login";
    }

    @GetMapping("/users")
    public String listAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "userList";
    }
}
