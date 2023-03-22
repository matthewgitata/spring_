package com.matthewgitata.springrestclientexamples.config;

/**
 * created by @matthewgitata on 22/03/2023.
 */
@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}