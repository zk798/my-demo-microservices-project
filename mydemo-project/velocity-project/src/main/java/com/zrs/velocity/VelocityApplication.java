package com.zrs.velocity;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/1")
@SpringBootApplication
public class VelocityApplication {
    public static void main(String[] args) {
        SpringApplication.run(VelocityApplication.class,args);
    }

    @RequestMapping("/2")
    public String velocityTest(){
      return new VelocityDemo().initVecocity();
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String loginPost() {
        return "222";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public String loginPost22() {
        return "111";
    }


}
