package com.zrs.th3.mail.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/oss")
public class OssController {
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



    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public String logout() {


        return "logout";
    }

}
