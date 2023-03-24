package com.matthewgitata.springjms.config;

/**
 * created by @matthewgitata on 24/03/2023.
 */
@EnableScheduling
@EnableAsync
@Configuration
public class TaskConfig {

    @Bean
    TaskExecutor taskExecutor() {
        return new SimpleAsyncTaskExecutor();
    }
}