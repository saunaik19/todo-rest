package com.saurabh.todo.rest.webservice.jwt.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncodeTest {
    public static void main(String args[]){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        for(int i=0;i<=10;i++) {
            String encodedString = encoder.encode("dummy");
            System.out.println("encoded password " + encodedString);
        }
    }
}
