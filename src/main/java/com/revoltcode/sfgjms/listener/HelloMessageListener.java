package com.revoltcode.sfgjms.listener;

import com.revoltcode.sfgjms.config.JmsConfig;
import com.revoltcode.sfgjms.model.HelloWorldMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class HelloMessageListener {

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders messageHeaders, Message message){

        /* NOTE: while there are different implementations of the JMS API,
         * any can be used with respect to the other E.g
         *
         * org.apache.activemq.artemis.api.core.Message; <==> javax.jms.Message
         */

        System.out.println("I got a message!!!");

        System.out.println(helloWorldMessage);
    }
}
