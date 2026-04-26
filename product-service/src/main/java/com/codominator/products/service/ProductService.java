package com.codominator.products.service;

import com.codominator.products.dto.request.ProductRequestDto;
import com.codominator.products.dto.response.ProductResponseDto;
import com.codominator.products.entity.Product;
import com.codominator.products.mapper.ProductMapper;

import com.codominator.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<ProductResponseDto> findAllProducts() {
        List<Product> products = productRepository.findAll();
       return products.stream().map(product -> productMapper.mapToProductResponseDto(product)).collect(Collectors.toList());
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public List<ProductResponseDto> searchProduct(String keywords) {
        return productRepository.searchProduct(keywords)
                .stream()
                .map(product -> productMapper.mapToProductResponseDto(product)).collect(Collectors.toList());
    }
}
