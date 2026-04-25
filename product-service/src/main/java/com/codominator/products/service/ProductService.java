package com.codominator.products.service;

import com.codominator.products.dto.request.ProductRequestDto;
import com.codominator.products.dto.response.ProductResponseDto;
import com.codominator.products.entity.Product;
import com.codominator.products.mapper.ProductMapper;

import com.codominator.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

@RequiredArgsConstructor

public class ProductService {
    private final ProductRepository productRepository;
    ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    public ProductResponseDto createProduct(ProductRequestDto ProductRequestDto) {
        Product product = productMapper.mapToProductRequestDto(ProductRequestDto);
        Product save = productRepository.save(product);
        return productMapper.mapToProductResponseDto(save);

    }

    public ProductResponseDto findProductById(Long id) {
        Optional<Product> productById = productRepository.findById(id);
        if (productById.isPresent()) {
            return productMapper.mapToProductResponseDto(productById.get());
        }
        throw new IllegalArgumentException("Product not found with id " + id);
    }
}
