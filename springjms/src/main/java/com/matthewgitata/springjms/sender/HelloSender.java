package com.matthewgitata.springjms.sender;

import com.matthewgitata.springjms.config.JmsConfig;
import com.matthewgitata.springjms.model.HelloWorldMessage;

import java.util.UUID;

/**
 * created by @matthewgitata on 24/03/2023.
 */
@RequiredArgsConstructor
@Component
public class HelloSender {

    private final JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 2000)
    public void sendMessage() {
        System.out.println("I'm sending a message");
        HelloWorldMessage message = HelloWorldMessage
                .builder()
                .id(UUID.randomUUID())
                .message("Hello World!")
                .build();

        jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE, message);

        System.out.println("Message Sent!");
    }
}