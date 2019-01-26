package com.zrs.rpc.consumer;

import com.zrs.rpc.api.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@RestController
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);
    }

    @GetMapping("/get")
    public User get(){
        RestTemplate restTemplate = new RestTemplate();
        User forObject = restTemplate.getForObject("http://127.0.0.1:8080/user", User.class);
        return forObject;
    }
    @GetMapping("/list")
    public List list(){
        RestTemplate restTemplate = new RestTemplate();
//        List list = restTemplate.getForObject("http://127.0.0.1:8080/user/list", List.class);



        List<User> list = restTemplate.exchange("http://127.0.0.1:8080/user/list",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {}).getBody();
        return list;
    }
}
