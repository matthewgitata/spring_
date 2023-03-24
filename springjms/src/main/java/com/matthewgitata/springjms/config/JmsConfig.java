package com.matthewgitata.springjms.config;

/**
 * created by @matthewgitata on 24/03/2023.
 */
@Configuration
public class JmsConfig {

    public static final String MY_QUEUE = "my-hello-world";
    public static final String MY_SEND_RCV_QUEUE = "replybacktome";

    @Bean
    public MessageConverter messageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter
    }
}