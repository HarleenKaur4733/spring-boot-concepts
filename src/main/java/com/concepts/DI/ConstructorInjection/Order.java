package com.concepts.DI.ConstructorInjection;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Order {

    public Order() {
        System.out.println("Order constructor");
    }
}
