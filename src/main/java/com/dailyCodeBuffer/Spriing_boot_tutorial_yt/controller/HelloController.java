package com.dailyCodeBuffer.Spriing_boot_tutorial_yt.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Tells that this is comtroller , and will give a ResponseBody
@RestController
public class HelloController {

//    @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String helloWorld(){
        return "Welcome to Spring Boot Tutorial YT a a a ";
    }
}
