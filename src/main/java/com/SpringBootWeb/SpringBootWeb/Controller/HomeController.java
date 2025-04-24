package com.SpringBootWeb.SpringBootWeb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/home")
public class HomeController {

    @GetMapping("/index")
    public String index()
    {
        return "index.jsp";
    }

    @GetMapping(path = "/sum")
    public String sum()
    {
        return "index.jsp";
    }
}
