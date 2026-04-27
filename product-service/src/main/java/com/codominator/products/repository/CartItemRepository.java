package com.codominator.products.repository;

import com.codominator.products.entity.CartItem;
import com.codominator.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByUserIdAndProduct(String userId, Product product);

    void deleteByUserIdAndProduct(String userId, Product product);


    List<CartItem> findByUserId(String userId);
}
