package com.codominator.products.repository;

import com.codominator.products.entity.CartItem;
import com.codominator.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByUserIdAndProduct(String userId, Product product);
}
