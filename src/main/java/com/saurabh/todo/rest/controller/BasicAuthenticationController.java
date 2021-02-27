package com.saurabh.todo.rest.controller;

import com.saurabh.todo.rest.bean.AuthenticationBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200","http://192.168.0.103:4200"})
public class BasicAuthenticationController {

    @GetMapping(path = "/auth/")
    public AuthenticationBean authenticate(){
    return new AuthenticationBean("You are authenticated.......");
    }
}
