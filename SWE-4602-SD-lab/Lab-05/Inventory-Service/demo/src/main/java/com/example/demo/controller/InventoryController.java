package com.example.demo.controller;

import com.example.demo.Constants;
import com.example.demo.entity.InventoryStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InventoryController {

    @RabbitListener(queues = Constants.QUEUE )
    public void consumeMessageFromQueue(InventoryStatus inventoryStatus) {
        System.out.println("Message Received from queue: " +inventoryStatus );
    }
}