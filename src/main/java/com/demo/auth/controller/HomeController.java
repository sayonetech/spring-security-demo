package com.demo.auth.controller;


import com.demo.auth.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/v1/user")
public class HomeController {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }

    @RequestMapping(value = "/resource", method = RequestMethod.GET)
    public Map<String, Object> getResource() {
        Map<String, Object> resource = new HashMap<String, Object>();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        resource.put("user", user);
        //resource.put("addresses", user.getUserAddresses());
        return resource;
    }


    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }
}