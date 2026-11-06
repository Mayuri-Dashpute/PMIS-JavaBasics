package com.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class printTest {
    @GetMapping("/hi")
    public String hi(){
        return "Hi Mayuri";
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello Mayuri";
    }

    @GetMapping("/hallo")
    public String hallo(){
        return "Hallo Mayuri";
    }
}
