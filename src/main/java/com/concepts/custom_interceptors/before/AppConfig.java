package com.concepts.custom_interceptors.before;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    // Register your custom interceptor here

    // ** Two ways to create bean of interceptor **
    // @Autowired
    // MyCustomInterceptor myCustomInterceptor;

    @Bean
    public MyCustomInterceptor myCustomInterceptor() {
        return new MyCustomInterceptor();
    }

    // Register the interceptor
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myCustomInterceptor()).addPathPatterns("/users/*").excludePathPatterns(
                "/users/updatedUser",
                "users/deleteUser");
    }

}
