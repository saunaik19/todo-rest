package com.saurabh.todo.rest.basic;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller
@CrossOrigin(origins={"http://localhost:4200","http://192.168.0.103:4200"})
@RestController
public class BasicAuthenticationController {

    @GetMapping(path = "/basicAuth")
    public AuthenticationBean helloWorldBean() {
        //throw new RuntimeException("Some Error has Happened! Contact Support at ***-***");
        return new AuthenticationBean("You are authenticated");
    }   
}