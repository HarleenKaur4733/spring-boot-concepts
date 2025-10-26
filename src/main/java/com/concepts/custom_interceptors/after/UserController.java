package com.concepts.custom_interceptors.after;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    User user;

    @GetMapping("/details")
    public String fetchUser() {
        user.getUser();
        return "User details fetched!";
    }
}
