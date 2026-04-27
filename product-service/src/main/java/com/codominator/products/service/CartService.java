package com.codominator.products.service;

import com.codominator.products.dto.external.UserDto;
import com.codominator.products.dto.request.CartItemRequest;
import com.codominator.products.entity.CartItem;
import com.codominator.products.entity.Product;
import com.codominator.products.repository.CartItemRepository;
import com.codominator.products.repository.ProductRepository;
import com.codominator.products.restCalls.UserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
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
            System.out.println("product not found");
            return false;
        }
        System.out.println("product found checking stocks and updating cart ");
        Product product = findProductById.get();
        if (product.getStockQuantity() < cartItemRequest.getQuantity()){
            System.out.println("request stock is not available");
            return false;
        }

        CartItem existingItem = cartItemRepository.findByUserIdAndProduct(userId, product);
        if(existingItem != null){
            System.out.println("request already exists");
            existingItem.setQuantity(existingItem.getQuantity() + cartItemRequest.getQuantity());
            existingItem.setPrice(product.getPrice().multiply(BigDecimal.valueOf(existingItem.getQuantity())));
            cartItemRepository.save(existingItem);
        }
        else{
            System.out.println("creating cart item");
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setUserId(userId);
            cartItem.setPrice(product.getPrice().multiply(BigDecimal.valueOf(cartItemRequest.getQuantity())));
            cartItem.setQuantity(cartItemRequest.getQuantity());
            cartItemRepository.save(cartItem);

        }
        return true;
    }
}
