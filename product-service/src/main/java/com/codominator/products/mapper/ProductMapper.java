package com.codominator.products.mapper;

import com.codominator.products.dto.request.ProductRequestDto;
import com.codominator.products.dto.response.ProductResponseDto;
import com.codominator.products.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product mapToProductRequestDto(ProductRequestDto productRequestDto);
    ProductRequestDto toProductRequestDto(Product product);
    ProductResponseDto mapToProductResponseDto(Product product);

}
