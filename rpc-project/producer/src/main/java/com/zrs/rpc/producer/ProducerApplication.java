package com.zrs.rpc.producer;

import com.zrs.rpc.api.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class,args);
    }


    @GetMapping("/user")
    public User getUser(){
        return new User(1,"lucy");
    }

    @GetMapping("/user/list")
    public List<User> getUserList(){
        List<User> list = new ArrayList<>();
        list.add(new User(1,"lucy"));
        list.add(new User(2,"zhang"));
        return list;
    }
}