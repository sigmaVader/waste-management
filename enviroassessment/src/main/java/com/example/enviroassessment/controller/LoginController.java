package com.example.enviroassessment.controller;


import com.example.enviroassessment.dto.UserDto;
import com.example.enviroassessment.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserDto userDto){

        return userService.RegisterUser(userDto);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDto user, HttpSession session){

        UserDto loggedInUser = userService.login(user.getEmailAddress(),user.getPassword());

        if(loggedInUser == null){

            return "Invalid email or password";
        }

        session.setAttribute("userId", loggedInUser.getId());

        return "User successfully logged in";
    }






}
