package com.demo.auth.controller;


import com.demo.auth.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public Map<String, String> getResource() {
        Map<String, String> resource = new HashMap<String, String>();
        resource.put("resource", "here is some resource");
        return resource;
    }

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody LoginRequest params,
                                HttpServletRequest request, HttpServletResponse response, BindingResult result) throws ServletException {
        return new ResponseEntity(HttpStatus.OK);
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