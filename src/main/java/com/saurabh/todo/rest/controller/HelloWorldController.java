package com.saurabh.todo.rest.controller;

import com.saurabh.todo.rest.bean.HelloWorldBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins ={"http://localhost:4200"})
@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World Sir...";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
      //  throw new RuntimeException("Nahi det value jaa kay kartes te kar, furrrrrrrr..");
       return new HelloWorldBean("Hello World from Bean");
    }

    @GetMapping(path = "/hello-world/pv/{user}")
    public HelloWorldBean helloWorldBeanToUser(@PathVariable(name = "user") String user){
        return new HelloWorldBean(String.format("Hello World from Bean to %s ",user));
    }
}
