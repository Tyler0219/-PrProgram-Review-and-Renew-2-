package com.unitseven.springboot.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class orders {
    @Id
    @GeneratedValue
    private int order_id;
    private int user_id;
    private LocalDateTime order_date;
    private BigDecimal total_amount;
    private String status;
}
