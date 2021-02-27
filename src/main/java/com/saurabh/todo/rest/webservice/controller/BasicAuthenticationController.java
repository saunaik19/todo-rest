package com.saurabh.todo.rest.webservice.controller;

import com.saurabh.todo.rest.basic.AuthenticationBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200","http://192.168.0.103:4200"})
public class BasicAuthenticationController {

    @GetMapping(path = "/basicAuth")
    public AuthenticationBean authenticate(){
    return new AuthenticationBean("You are authenticated.......");
    }
}
