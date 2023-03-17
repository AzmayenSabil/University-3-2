package com.example.demo.valueObject;

import com.example.demo.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseValueObject{
//    private Customer customer;
//    private Product product;
    private Employee employee;
    private Order order;
}
