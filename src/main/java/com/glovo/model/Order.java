package com.glovo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class Order {
    private int orderId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private List<Product> products;
}
