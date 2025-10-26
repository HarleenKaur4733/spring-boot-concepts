package com.concepts.custom_interceptors.after;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

// aspect will make a proxy of method
@Aspect
@Component
public class MyCustomInterceptor {

    @Around("@annotation(com.concepts.custom_interceptors.after.MyCustomAnnotation)") // pointcut expression
    public void ivoke(ProceedingJoinPoint jointPoint) throws Throwable {
        System.out.println("Before invoking method with MyCustomAnnotation");

        // trying to get name attribute from annotation before method execution
        Method method = ((MethodSignature) jointPoint.getSignature()).getMethod();

        // check if annotation is present
        if (method.isAnnotationPresent(MyCustomAnnotation.class)) {
            MyCustomAnnotation annotation = method.getAnnotation(MyCustomAnnotation.class);
            System.out.println("Annotation name attribute: " + annotation.name());
        }

        // run the actual method now
        jointPoint.proceed();

        System.out.println("After invoking method with MyCustomAnnotation");
    }

}
