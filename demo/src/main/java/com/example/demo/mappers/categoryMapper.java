package com.example.demo.mappers;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.CategoryEntity;

public class categoryMapper {
    
    public static CategoryDTO toDto(CategoryEntity categoryEntity) {
        return CategoryDTO.builder()
                .name(categoryEntity.getName())
                .build();
    }
    
    
    public static CategoryEntity toEntity(CategoryDTO  categoryDTO) {
        return CategoryEntity.builder()
                .name(categoryDTO.getName())
                .build();
    }
    
    
}
