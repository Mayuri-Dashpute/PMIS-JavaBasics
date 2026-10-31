package com.foodorder.controller;

import com.foodorder.dto.OrderRequest;
import com.foodorder.entity.CustomerOrder;
import com.foodorder.service.OrderService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<CustomerOrder> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public CustomerOrder getOrderById(
            @PathVariable Long orderId) {

        return orderService.getOrderById(orderId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerOrder createOrder(
            @RequestBody OrderRequest request) {

        return orderService.createOrder(request);
    }
}