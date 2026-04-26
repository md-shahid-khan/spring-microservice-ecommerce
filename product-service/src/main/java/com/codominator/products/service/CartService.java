package com.codominator.products.service;

import com.codominator.products.dto.external.UserDto;
import com.codominator.products.dto.request.CartItemRequest;
import com.codominator.products.entity.Product;
import com.codominator.products.repository.CartItemRepository;
import com.codominator.products.repository.ProductRepository;
import com.codominator.products.restCalls.UserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
private final ProductRepository productRepository;
private final CartItemRepository cartItemRepository;
private final UserClient userClient;

    public boolean addToCart(String userId, CartItemRequest cartItemRequest){

        // fetching the user details
        UserDto userById = userClient.getUserById(userId);
        if(userById==null){
            return false;
        }
        // looking for the product
        Optional<Product> findProductById = productRepository.findById(cartItemRequest.getProductId());
        if(findProductById.isEmpty()){
            return false;
        }
        Product product = findProductById.get();
        if (product.getStockQuantity() < cartItemRequest.getQuantity()){
            return false;
        }

        CartItem existingItem = cartItemRepository.findByUserAndProduct()
    }
}
