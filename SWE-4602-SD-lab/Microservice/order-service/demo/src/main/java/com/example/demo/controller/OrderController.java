package com.example.demo.controller;

import com.example.demo.entity.Order;
import com.example.demo.valueObject.ResponseValueObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public Order saveOrder(@RequestBody Order order){
        System.out.println("Post request");
        return orderService.saveOrder(order);
    }

//    @GetMapping("/{id}")
//    public Order findOrderById(@PathVariable("id") String orderId){
//        System.out.println("Get request");
//        return orderService.findOrderById(orderId);
//    }

    @GetMapping("/{id}")
    public ResponseValueObject getOrderWithEmployee(@PathVariable("id") String orderId){
        System.out.println("Get request");
        return orderService.getOrderWithEmployee(orderId);
    }
}
