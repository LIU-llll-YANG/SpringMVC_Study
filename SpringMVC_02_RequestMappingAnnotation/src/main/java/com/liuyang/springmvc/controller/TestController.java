package com.liuyang.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/test")
public class TestController {

    //@RequestMapping("/success")
    //public String locationTheTestRequestMappingAnnotation(){
    //    return "success";
    //}

    //@RequestMapping(value = {"/success","/win"})
    //public String manyRequestMappingAnnotation(){
    //    return "success";
    //}

    //@RequestMapping(
    //        value = "success",
    //        method = RequestMethod.GET
    //)
    //public String requestMappingMethodAttribute(){
    //    return "success";
    //}

    //@PostMapping(
    //        value = "success"
    //)
    //public String requestMappingMethodAttribute(){
    //    return "success";
    //}


    @RequestMapping(
            value = "/success",
            params = {"username"}
    )
    public String requestMappingParam(){
        return "success";
    }

}
