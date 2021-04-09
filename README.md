# sfg-jms

NOTE: while there are different implementations of the JMS API, any can be used with respect to the other E.g

* org.apache.activemq.artemis.api.core.Message <==> javax.jms.Message

Further examples: Spring has various abstractions (jms & messaging) for these classes:

* org.springframework.jms.support.converter.MappingJackson2MessageConverter <==> org.springframework.messaging.converter.MappingJackson2MessageConverter
  
* org.springframework.jms.support.converter.MessageConverter <==> import org.springframework.messaging.converter.MessageConverter