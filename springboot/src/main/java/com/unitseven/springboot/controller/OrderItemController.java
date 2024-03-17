package com.unitseven.springboot.controller;

import com.unitseven.springboot.Entity.OrderItem;
import com.unitseven.springboot.Service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/create")
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.saveOrderItem(orderItem);
    }

    @GetMapping("/{orderItemId}")
    public Optional<OrderItem> getOrderItemById(@PathVariable int orderItemId) {
        return orderItemService.getOrderItemById(orderItemId);
    }

    @GetMapping("/all")
    public List<OrderItem> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    @DeleteMapping("/{orderItemId}")
    public void deleteOrderItem(@PathVariable int orderItemId) {
        orderItemService.deleteOrderItem(orderItemId);
    }
}