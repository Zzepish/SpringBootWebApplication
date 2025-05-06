package com.example.SecurityLearning.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/world")
    public String helloWorld(HttpServletRequest request)
    {
        return "Hello World - " + request.getSession().getId();
    }

    @GetMapping("/about")
    public String about(HttpServletRequest request)
    {
        return "Zzepish - " + request.getSession().getId();
    }
}
