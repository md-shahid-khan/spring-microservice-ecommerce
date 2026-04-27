package com.codominator.products.controller;

import com.codominator.products.dto.request.CartItemRequest;
import com.codominator.products.service.CartService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping
    public ResponseEntity<?> addToCart(@RequestHeader(name = "X-User-ID") String id, @RequestBody CartItemRequest cartItemRequest){
        return new ResponseEntity<>(cartService.addToCart(id,cartItemRequest), HttpStatus.OK);
    }

}
