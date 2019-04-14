package com.zrs.velocity;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
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

}
