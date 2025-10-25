package com.concepts.DI.ConstructorInjection;

import javax.swing.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {

    // can easily use final now: values sari constructor initialze k sme set ho
    // chukki hai
    public final Order order;

    @Autowired
    // ek aur cheez, hme number of dependencies ka pta chl jayega, agr jada hai toh
    // its good time to refractor it
    public User(Order order) {
        System.out.println("User initialized");
        this.order = order;
    }
    // Spring uses constructor injection, which means:

    // Spring cannot create User until it has a valid Order instance to pass into
    // the constructor.

    // So Spring creates the Order object first.

    // Then it calls the User constructor and injects the Order instance.
}
