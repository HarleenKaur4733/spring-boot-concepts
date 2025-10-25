package com.concepts.DI.SetterInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {

    Order order;

    @Autowired

    public void setUser(Order order) {
        System.out.println("Using setter injection");
        this.order = order;
    }
}
