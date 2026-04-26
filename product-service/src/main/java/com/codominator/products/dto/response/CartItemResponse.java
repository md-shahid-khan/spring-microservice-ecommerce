package com.codominator.products.dto.response;

import com.codominator.products.entity.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CartItemResponse {

    private Long id;
    private String  userId;
    private Product product;
    private Integer quantity;
    private BigDecimal price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
