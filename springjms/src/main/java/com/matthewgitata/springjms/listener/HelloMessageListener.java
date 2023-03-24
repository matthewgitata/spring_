package com.matthewgitata.springjms.listener;

import com.matthewgitata.springjms.config.JmsConfig;
import com.matthewgitata.springjms.model.HelloWorldMessage;

/**
 * created by @matthewgitata on 24/03/2023.
 */
@Component
public class HelloMessageListener {

    @JmsListener(destination= JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders headers, Message message) {

        System.out.println("I Got A Message!!!!!");

        System.out.println(helloWorldMessage);
    }
}