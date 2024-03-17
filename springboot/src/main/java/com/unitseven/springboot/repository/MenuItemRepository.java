package com.unitseven.springboot.repository;

import com.unitseven.springboot.Entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {


}