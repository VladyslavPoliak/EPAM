package com.spring.controller;

import com.spring.entity.Role;
import com.spring.entity.User;
import com.spring.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Optional;

@Controller
public class RegistrationController {

    private final IUserService userService;

    public RegistrationController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addNewUser(User user, Model model) {

        Optional<User> userFromDB = Optional.ofNullable(userService.findByUsername(user.getUsername()));
        if (userFromDB.isPresent()) {
            model.addAttribute("message", "USer exists");
            return "registration";
        }
        user.setRoles(Collections.singleton(Role.USER));
        userService.save(user);
        return "redirect:/login";
    }
}
