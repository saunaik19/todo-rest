package com.saurabh.todo.rest.webservice.jwt.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncodeTest {
    public static void main(String args[]){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

        String encodedString=encoder.encode("dummy");
        System.out.println("encoded password "+encodedString);
    }
}
