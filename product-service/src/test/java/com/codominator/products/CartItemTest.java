package com.codominator.products;

import com.codominator.products.dto.request.CartItemRequest;
import com.codominator.products.service.CartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CartItemTest {
    @Autowired
    CartService cartService;
    @Test
    public void cartItemTest(){
        CartItemRequest cartItemRequest = new CartItemRequest();
        cartItemRequest.setProductId(1L);
        cartItemRequest.setQuantity(3);
        cartService.addToCart(String.valueOf(1), cartItemRequest);
    }
}
