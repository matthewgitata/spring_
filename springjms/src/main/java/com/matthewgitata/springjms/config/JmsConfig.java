package com.matthewgitata.springjms.config;

/**
 * created by @matthewgitata on 24/03/2023.
 */
@Configuration
public class JmsConfig {

    @Bean
    public MessageConverter messageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter
    }
}