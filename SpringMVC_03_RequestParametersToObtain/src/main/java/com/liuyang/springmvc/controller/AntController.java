package com.liuyang.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AntController {

    @RequestMapping("/testAnt/**")
    public String testAnt() {
        return "success";
    }

    @RequestMapping("/testAPlaceholder/{id}/{name}")
    public String testAPlaceholder(@PathVariable int id, @PathVariable String name) {
        System.out.println("id = " + id);
        System.out.println("name = " + name);
        return "success";
    }
}
