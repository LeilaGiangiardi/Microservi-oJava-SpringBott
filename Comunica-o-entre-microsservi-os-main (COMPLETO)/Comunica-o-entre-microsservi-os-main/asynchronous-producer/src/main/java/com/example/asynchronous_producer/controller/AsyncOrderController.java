package com.example.asynchronous_producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.asynchronous_producer.service.OrderMessageProducer;

@RestController
@RequestMapping("/async-order")
public class AsyncOrderController {

    @Autowired
    private OrderMessageProducer orderMessageProducer;

    @PostMapping("/{orderId}")
    public ResponseEntity<String> sendOrder(@PathVariable("orderId") Long orderId) {
        orderMessageProducer.sendOrder(orderId);
        return ResponseEntity.ok("Order sent asynchronously: " + orderId);
    }
}
