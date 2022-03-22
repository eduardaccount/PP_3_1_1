package com.example.springboot.controller;

import com.example.springboot.model.User;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getMainPage(Model model) {
        model.addAttribute("people", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/addingUser")
    public String newPerson(@ModelAttribute("new_user") User user) {
        return "add";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("new_user") User user) {
        userService.addUser(user);
        return "redirect:/users/";
    }

    @GetMapping("/editPage")
    public String editPage(@RequestParam(value = "id") String id, Model model) {
        User user = userService.getUserById(Long.parseLong(id));
        model.addAttribute("current_user", user);
        return "edit";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users/";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam(value = "id") String id) {
        userService.deleteUser(Long.parseLong(id));
        return "redirect:/users/";
    }
}