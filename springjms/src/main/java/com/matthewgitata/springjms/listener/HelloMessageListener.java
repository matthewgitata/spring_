package com.matthewgitata.springjms.listener;

import com.matthewgitata.springjms.config.JmsConfig;
import com.matthewgitata.springjms.model.HelloWorldMessage;

import javax.print.attribute.standard.Destination;
import java.util.UUID;

/**
 * created by @matthewgitata on 24/03/2023.
 */
@RequiredArgsConstructor
@Component
public class HelloMessageListener {

    private final JmsTemplate jmsTemplate;

    @JmsListener(destination= JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders headers, Message message) {
    }

    @JmsListener(destination= JmsConfig.MY_SEND_RCV_QUEUE)
    public void listenForHello(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders headers, Message message) {

        HelloWorldMessage payloadMsg = HelloWorldMessage
                .builder()
                .id(UUID.randomUUID())
                .message("World!")
                .build();

        jmsTemplate.convertAndSend(message.getJMSReplyTo(), payloadMsg);
    }
}