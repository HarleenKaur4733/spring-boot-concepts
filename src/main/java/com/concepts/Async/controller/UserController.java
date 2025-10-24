package com.concepts.Async.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concepts.Async.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(value = "/api/")
public class UserController {

    @Autowired
    UserService userServiceObj;

    @GetMapping(path = "/getUser")
    public String getUserMethod() {

        System.out.println("Inside getUserMethod: " + Thread.currentThread().getName());
        userServiceObj.asyncMethodTest();
        return "Hi";

    }

}
