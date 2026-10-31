package com.foodorder.service;

import com.foodorder.dto.OrderRequest;
import com.foodorder.entity.CustomerOrder;
import com.foodorder.entity.Food;
import com.foodorder.exception.ResourceNotFoundException;
import com.foodorder.repository.FoodRepository;
import com.foodorder.repository.OrderRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final FoodRepository foodRepository;

    public OrderService(OrderRepository orderRepository,
                        FoodRepository foodRepository) {

        this.orderRepository = orderRepository;
        this.foodRepository = foodRepository;
    }

    public List<CustomerOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    public CustomerOrder getOrderById(Long id) {

        return orderRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Order not found with id: " + id));
    }

    public CustomerOrder createOrder(OrderRequest request) {

        Food food = foodRepository.findById(request.getFoodId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Food not found with id: "
                                        + request.getFoodId()));

        if (!food.isAvailable()) {
            throw new IllegalArgumentException(
                    "This food item is currently unavailable");
        }

        if (request.getQuantity() == null ||
                request.getQuantity() <= 0) {
            throw new IllegalArgumentException(
                    "Quantity must be greater than zero");
        }

        CustomerOrder order = new CustomerOrder();

        order.setCustomerName(request.getCustomerName());
        order.setQuantity(request.getQuantity());
        order.setFood(food);

        order.setTotalPrice(
                food.getPrice() * request.getQuantity());

        order.setOrderDate(LocalDateTime.now());

        return orderRepository.save(order);
    }
}