package com.coma.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController
{
    //test URL exposed
    @GetMapping("/hello")
    public String hello()
    {
	return "Hello world";
    }
    
    @GetMapping("/hel")
    public String hello1()
    {
	return "Hello world";
    }
}
