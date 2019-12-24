package com.web.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping({"/","/index.html"})
    public String index(){
    return  "index";
   }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello world";

    }
    @RequestMapping({"/da","/da.html"})
    public String index1(){
        return  "dashboard";
    }
    @RequestMapping("/main.html")
    public String main(){
        return  "dashboard";
    }


}
