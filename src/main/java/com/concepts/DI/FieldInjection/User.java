package com.concepts.DI.FieldInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {

    // disadvantage:
    // a final field must be assigned exactly once, and it must be assigned before
    // the constructor finishes.
    @Autowired
    Order order;

    public User() {
        System.out.println("User constructor called");
    }
}
