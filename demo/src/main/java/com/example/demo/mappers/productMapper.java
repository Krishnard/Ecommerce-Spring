package com.example.demo.mappers;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.ProductEntity;

public class productMapper {
    
    public static ProductDTO toDTO(ProductEntity productEntity){
        
        return ProductDTO.builder()
                .id(productEntity.getId())
                .brand(productEntity.getBrand())
                .image(productEntity.getImage())
                .color(productEntity.getColor())
                .price(productEntity.getPrice())
                .description(productEntity.getDescription())
                .discount(productEntity.getDiscount())
                .model(productEntity.getModel())
                .title(productEntity.getTitle())
                .category(productEntity.getCategory())
                .popular(productEntity.isPopular())
                .build();
    }
    
    public static ProductEntity toEntity(ProductDTO dto) {
        
        return ProductEntity.builder()
                .image(dto.getImage())
                .color(dto.getColor())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .discount(dto.getDiscount())
                .model(dto.getModel())
                .title(dto.getTitle())
                .category(dto.getCategory())
                .brand(dto.getBrand())
                .popular(dto.isPopular())
                .build();
    }
}
