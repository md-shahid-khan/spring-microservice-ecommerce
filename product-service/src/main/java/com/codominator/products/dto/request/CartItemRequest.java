package com.codominator.products.dto.request;

import com.codominator.products.entity.Product;
import lombok.Data;
import lombok.ToString;


import java.math.BigDecimal;

@Data
@ToString
public class CartItemRequest {

    private Long productId;
    private Integer quantity;


}
