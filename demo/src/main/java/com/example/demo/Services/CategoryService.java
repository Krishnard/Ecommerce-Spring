package com.example.demo.Services;

import com.example.demo.Repository.categoryRepository;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.CategoryEntity;
import com.example.demo.mappers.categoryMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.demo.mappers.categoryMapper.toDto;

@Primary
@Service
public class CategoryService implements ICategoryService{
    
    private final categoryRepository categoryRepository; // Repository for CategoryEntity
    
    
    public CategoryService(categoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    
    
    
    
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (CategoryEntity categoryEntity : categoryRepository.findAll()){
            categoryDTOList.add(toDto(categoryEntity)); // Convert each entity to DTO
        }
        
        return categoryDTOList; // Return the list of DTOs
    }
    
    
    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDto) {
        CategoryEntity categoryEntity = categoryMapper.toEntity(categoryDto); // Convert DTO to Entity
        
        CategoryEntity categoryEntitySaved = categoryRepository.save(categoryEntity); // Save the entity
        
        CategoryDTO categoryDTO = toDto(categoryEntitySaved); // Convert saved entity back to DTO
        
        return categoryDTO; // return the DTO
    }
    
    
    @Override
    public CategoryDTO getCategoryByName(String name) throws Exception {
         CategoryEntity categoryEntity = categoryRepository.findByName(name)
                .orElseThrow(() -> new Exception("Category not found with name: " + name));
    
        return categoryMapper.toDto(categoryEntity); // Convert entity to DTO and return it
    
    }
    
}
