package com.concepts.custom_interceptors.before;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class MyCustomInterceptor implements HandlerInterceptor {

    // Runs before controller method
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("Custom Interceptor: Pre-handle logic executed");
        return true;
    }

    // Runs after controller method, before sending response
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println("Custom Interceptor: Post-handle logic executed");
    }

    // Runs after complete request is finished
    // Runs even if there is an exception
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("Custom Interceptor: After-completion logic executed");
    }
}
