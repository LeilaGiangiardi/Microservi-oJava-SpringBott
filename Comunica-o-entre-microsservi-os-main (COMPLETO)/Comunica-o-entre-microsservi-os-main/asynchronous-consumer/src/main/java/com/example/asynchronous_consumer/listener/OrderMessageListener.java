package com.example.asynchronous_consumer.listener;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.asynchronous_consumer.config.RabbitMQConfig;


@Service
public class OrderMessageListener {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveOrder(Long orderId) {
        System.out.println("Received async order: " + orderId);
        // Lógica para processar o pedido de forma assíncrona
    }
}

