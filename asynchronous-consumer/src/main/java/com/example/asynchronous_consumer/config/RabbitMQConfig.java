package com.example.asynchronous_consumer.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "orderQueue";
    public static final String EXCHANGE_NAME = "orderExchange";
    public static final String ROUTING_KEY = "orderRoutingKey";

    @Bean
    public Queue orderQueue() {
        return new Queue(QUEUE_NAME, false);
    }

    @Bean
    public TopicExchange orderExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue orderQueue, TopicExchange orderExchange) {
        return BindingBuilder.bind(orderQueue)
                .to(orderExchange)
                .with(ROUTING_KEY);
    }

    @Bean
    public MessageConverter messageConverter() {
        // Converter a mensagem em JSON, facilitando a serialização/deserialização de
        // objetos
        return new Jackson2JsonMessageConverter();
    }

    //@Bean
    //public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
      //  RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
      //  rabbitTemplate.setMessageConverter(messageConverter());
       // return rabbitTemplate;
   // }
}
