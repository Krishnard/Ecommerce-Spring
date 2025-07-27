package com.example.demo.mappers;

import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.ProductWithCategoryDTO;
import com.example.demo.entity.CategoryEntity;
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
//                .category(productEntity.getCategory()) // no more need after adding JPA relationship mapping
                .categoryId(productEntity.getCategory().getId()) // now we can get the category id from the category entity
                // ProductEntity has Category as an entity - which means first we need to get the category (.getCategory()) and then get the id (.getID())
                .popular(productEntity.isPopular())
                .build();
    }
    
    public static ProductEntity toEntity(ProductDTO dto, CategoryEntity categoryEntity){
        
        return ProductEntity.builder()
                .image(dto.getImage())
                .color(dto.getColor())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .discount(dto.getDiscount())
                .model(dto.getModel())
                .title(dto.getTitle())
                .brand(dto.getBrand())
                
                .category(categoryEntity) // setting the category entity directly
                
                .popular(dto.isPopular())
                .build();
    }
    
    
    public static ProductWithCategoryDTO toProductWithCategoryDTO(ProductEntity productEntity){
        
        return ProductWithCategoryDTO.builder()
                .image(productEntity.getImage())
                .color(productEntity.getColor())
                .price(productEntity.getPrice())
                .description(productEntity.getDescription())
                .discount(productEntity.getDiscount())
                .model(productEntity.getModel())
                .title(productEntity.getTitle())
                .brand(productEntity.getBrand())
                
                .category(categoryMapper.toDto(productEntity.getCategory()))
                // If we comment out this when using (fetch = FetchType.LAZY) then we won't get category info.
                
                .popular(productEntity.isPopular())
                .build();
        
    }
}
