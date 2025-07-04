package com.example.asynchronous_producer.service;



import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.asynchronous_producer.config.RabbitMQConfig;


@Service
public class OrderMessageProducer {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendOrder(Long orderId) {
        // Envia a mensagem para o exchange com a routing key especificada
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, orderId);
        System.out.println("Sent async order: " + orderId);
    }
}

