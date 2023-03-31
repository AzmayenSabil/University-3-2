package com.example.demo.controller;

import com.example.demo.Constants;
import com.example.demo.entity.OrderStatus;
import com.example.demo.entity.Product;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class InventoryController {

    @RabbitListener(queues = Constants.QUEUE )
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
        Product product1 = new Product();
        product1.setId("22");
        product1.setName("Headphone");
        product1.setQty(20);

        int quantityCheck = orderStatus.getOrder().getQty();
        String proId = orderStatus.getOrder().getProductId();

        if(quantityCheck != product1.getQty() && proId.equals("22")){
            System.out.println("Quantity did not match");
        }

        System.out.println("Message Received from queue: " +orderStatus );

    }
}