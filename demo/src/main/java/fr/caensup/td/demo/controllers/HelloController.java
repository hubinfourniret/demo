package fr.caensup.td.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @GetMapping("/")
    public ModelAndView sayHello() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message", "Hello World");
        mav.addObject("ret", "Goodbye World");
        return mav;
    }

    @GetMapping("/say/{msg}")
    @ResponseBody
    public String sayMessage(@PathVariable("msg") String message) {
        return message;
    }
}
