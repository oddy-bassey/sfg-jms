package com.revoltcode.sfgjms.listener;

import com.revoltcode.sfgjms.config.JmsConfig;
import com.revoltcode.sfgjms.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class HelloMessageListener {

    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders messageHeaders, Message message){

        /* NOTE: while there are different implementations of the JMS API,
         * any can be used with respect to the other E.g
         *
         * org.apache.activemq.artemis.api.core.Message; <==> javax.jms.Message
         */

        //System.out.println("I got a message!!!");

        //System.out.println(helloWorldMessage);
    }

    @JmsListener(destination = JmsConfig.MY_SEND_RCV_QUEUE)
    public void listenForHello(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders messageHeaders, Message message) throws JMSException {

        System.out.println("info --> "+helloWorldMessage.toString());

        HelloWorldMessage payloadMessage = HelloWorldMessage.builder()
                .id(UUID.randomUUID())
                .message("World!")
                .build();

        jmsTemplate.convertAndSend(message.getJMSReplyTo(), payloadMessage);
    }
}