package com.zrs.th3.mail.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * 首页内容管理Controller
 * Created by macro on 2019/1/28.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping(value = "/content", method = RequestMethod.GET)
    @ResponseBody
    @PreAuthorize("hasAuthority('123')")
    public String content() {

        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = ctx.getAuthentication();
        UserDetails memberDetails = (UserDetails) auth.getPrincipal();
        System.out.println(memberDetails);

        System.out.println("I am content");
        return "content";
    }

}
