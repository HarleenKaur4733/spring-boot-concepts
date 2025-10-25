package com.concepts.DI.FieldInjection;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy // jb use hoga tbhi initialize krna, vaise mt krna
public class Order {
    public Order() {
        System.out.println("Order constrcutor called..");
    }
}
