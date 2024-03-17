package com.unitseven.springboot.repository;

import com.unitseven.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
   
}
