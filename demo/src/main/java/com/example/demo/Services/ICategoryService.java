package com.example.demo.Services;

import com.example.demo.dto.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {
    
    List<CategoryDTO> getAllCategories() throws IOException;
    
    CategoryDTO createCategory(CategoryDTO categoryDto) ;
    
    CategoryDTO getCategoryByName(String name) throws Exception;
}
