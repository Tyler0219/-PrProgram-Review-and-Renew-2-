package com.unitseven.springboot.repository;

import com.unitseven.springboot.Entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
   
    
}