package com.example.SecurityLearning.Controller;

import com.example.SecurityLearning.Entity.User;
import com.example.SecurityLearning.Service.JWTService;
import com.example.SecurityLearning.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    @PostMapping("/register")
    public User register(@ModelAttribute User user)
    {
        try {
            user = this.userService.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Username already exists");
        }
        return user;
    }

    @PostMapping("/login")
    public Map<String, String> login(@ModelAttribute User user)
    {
        // We need AuthenticationManager in this case just to validate User login info
        this
            .authenticationManager
            .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        Map<String,String> map = new HashMap<>();
        map.put("token", this.jwtService.generateToken(user.getUsername()));
        return map;
    }
}
