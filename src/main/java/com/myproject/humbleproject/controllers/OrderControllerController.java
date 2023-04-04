package com.myproject.humbleproject.controllers;

import com.myproject.humbleproject.entities.Order;
import org.springframework.web.bind.annotation.*;
import com.myproject.humbleproject.repositories.OrderRepository;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderControllerController {
    private final OrderRepository orderRepository;

    public OrderControllerController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

}