package com.concepts.custom_interceptors.after;

import org.springframework.stereotype.Component;

@Component
public class User {

    @MyCustomAnnotation(name = "FetchUser")
    public void getUser() {
        System.out.println("Fetching user details...");
    }

}
