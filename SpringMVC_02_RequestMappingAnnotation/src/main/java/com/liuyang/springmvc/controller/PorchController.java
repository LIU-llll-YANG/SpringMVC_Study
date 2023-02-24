package com.liuyang.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PorchController {

    @RequestMapping("/")
    public String Porch(){
        return "index";
    }
}
