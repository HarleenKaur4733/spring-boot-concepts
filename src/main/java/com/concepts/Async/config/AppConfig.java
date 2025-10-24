package com.concepts.Async.config;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AppConfig implements AsyncConfigurer {

    // *********CASE2**********ThreadPoolTaskExecutor : Spring one
    // @Bean
    // public Executor taskPoolExecutor() {
    // int minPoolSize = 2;
    // int maxPoolSize = 4;
    // int queueSize = 3;

    // ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();
    // poolTaskExecutor.setCorePoolSize(minPoolSize);
    // poolTaskExecutor.setMaxPoolSize(maxPoolSize);
    // poolTaskExecutor.setQueueCapacity(queueSize);
    // poolTaskExecutor.setThreadNamePrefix("My Thread : ");
    // poolTaskExecutor.initialize();

    // return poolTaskExecutor;

    // }

    // *********CASE3********** ThreadPoolExecutor : Java One

    // @Bean(name = "myThreadPoolExecutor")
    // public Executor taskPoolExecutor() {

    // ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 4,
    // 1, TimeUnit.HOURS,
    // new ArrayBlockingQueue<>(3),
    // Executors.defaultThreadFactory());
    // return poolExecutor;
    // }

    // ************Industry Standard************************

    // You override getAsyncExecutor() → Spring will always use your
    // ThreadPoolExecutor for any method annotated with @Async.

    private ThreadPoolExecutor poolExecutor;

    @Override
    public synchronized Executor getAsyncExecutor() {
        if (poolExecutor == null) {
            int corePoolSize = 2;
            int maxPoolSize = 4;
            int queueCapacity = 3;
            long keepAliveTime = 1L;

            poolExecutor = new ThreadPoolExecutor(
                    corePoolSize,
                    maxPoolSize,
                    keepAliveTime,
                    TimeUnit.HOURS,
                    new ArrayBlockingQueue<>(queueCapacity),
                    Executors.defaultThreadFactory());
        }

        return poolExecutor;
    }

}

// Q: Why we have used synchronized keyword?
// Take bean wala reference, by default bean is singleton. I dont
// want threadpool to be created again and again.