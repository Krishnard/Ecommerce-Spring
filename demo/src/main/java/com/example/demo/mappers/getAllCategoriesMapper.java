package com.example.demo.mappers;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.FakeStoreCategoryResponseDTO;


import java.util.List;

public class getAllCategoriesMapper {

    public static FakeStoreCategoryResponseDTO toFakeStoreCategoryDTO(){
        return null;
    }
    
    public static List<CategoryDTO> toCategoryDTO(FakeStoreCategoryResponseDTO dto){
        return dto.getCategories()
                .stream()
                .map(category -> CategoryDTO.builder().name(category).build())
                .toList();
    }
}
