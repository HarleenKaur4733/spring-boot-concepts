package com.concepts.Async.service;

import javax.swing.Spring;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    // If you define nothing → Spring Boot uses SimpleAsyncTaskExecutor.

    // If you define a Spring-managed ThreadPoolTaskExecutor →
    // Spring Boot automatically uses it.

    // If you define only a raw Java ThreadPoolExecutor →
    // Spring Boot ignores it for async and still uses SimpleAsyncTaskExecutor,
    // unless you explicitly name it in @Async("beanName").

    @Async("myThreadPoolExecutor")
    public void asyncMethodTest() {
        System.out.println("inside asyncMethodTest: " + Thread.currentThread().getName());
    }
}
