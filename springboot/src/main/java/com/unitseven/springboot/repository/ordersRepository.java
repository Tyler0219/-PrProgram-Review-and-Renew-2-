package com.unitseven.springboot.repository;

import com.unitseven.springboot.Entity.orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ordersRepository extends JpaRepository<orders, Integer>{

    
}
