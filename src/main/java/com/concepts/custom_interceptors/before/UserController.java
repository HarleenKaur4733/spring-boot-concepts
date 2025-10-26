package com.concepts.custom_interceptors.before;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")

public class UserController {

    @GetMapping("/greet")
    public String greet() {
        return "Hello, User!";
    }

}
