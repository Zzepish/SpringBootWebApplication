package com.SpringBootWeb.SpringBootWeb.Controller;

import com.SpringBootWeb.SpringBootWeb.DTO.Sum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/home")
public class HomeController {

    @GetMapping("/index")
    public String index()
    {
        return "index";
    }

    /**
     *
     * num1 and num2 will be mapped from request corresponding fields.
     * Also: num1 and num2 form field will create DTO - Sum, with filled corresponding params
     */
    @PostMapping(path = "/sum")
    public ModelAndView sum(@RequestParam int num1, @RequestParam int num2, @ModelAttribute Sum sum, ModelAndView modelAndView)
    {
        modelAndView.setViewName("sum");
        modelAndView.addObject("sum", sum);

        return modelAndView;
    }
}
