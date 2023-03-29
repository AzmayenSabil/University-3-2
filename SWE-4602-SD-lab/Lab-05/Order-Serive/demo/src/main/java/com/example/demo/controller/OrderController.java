package com.example.demo.controller;

import com.example.demo.Constants;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/{restaurantName}")
    public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName ) {
        order.setOrderId(UUID.randomUUID().toString());
        OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "Order Successfully Placed to "+ restaurantName);

        rabbitTemplate.convertAndSend(Constants.EXCHANGE,Constants.ROUTING_KEY, orderStatus);
        return "success!!";
    }
}