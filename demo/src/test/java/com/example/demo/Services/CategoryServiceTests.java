package com.example.demo.Services;

import com.example.demo.Repository.categoryRepository;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.CategoryEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
// This has made the mockito extension available for the test class with JUnit.
public class CategoryServiceTests {
    
    @Mock
    private categoryRepository categoryRepository;
    
    @InjectMocks
    private CategoryService categoryService;
    
    private CategoryDTO categoryDTO;
    private CategoryEntity categoryEntity1;
    private CategoryEntity categoryEntity2;
    private CategoryEntity categoryEntity3;
    
    
    @BeforeEach
    void setup(){
        categoryDTO = CategoryDTO.builder().name("Electronics").build();
        categoryEntity1 = CategoryEntity.builder().name("Electronics").build();
        categoryEntity1.setId(1L);
        categoryEntity2 = CategoryEntity.builder().name("Books").build();
        categoryEntity2.setId(2L);
        categoryEntity3 = CategoryEntity.builder().name("Toys").build();
        categoryEntity3.setId(3L);
    }

    @Test
    @DisplayName("Should Return all Categories successfully")
    void getAllCategories_shouldReturnAllCategories() throws IOException {
        // method name should be - functionName_whatFunctionShouldDo;
    
        // Three steps
        // 1. Arrange - set up the test data, mocks, and expected results.
        
        List<CategoryEntity> categories = new ArrayList<>();
        
        /*
        Can remove this when we add the @BeforeEach method.
        
        CategoryEntity category1 = CategoryEntity.builder().name("Electronics").build();
        category1.setId(1L);
        CategoryEntity category2 = CategoryEntity.builder().name("Books").build();
        category2.setId(2L);
        
         */
        
        categories.add(categoryEntity1);
        categories.add(categoryEntity2);
        categories.add(categoryEntity3);
        
        when(categoryRepository.findAll()).thenReturn(categories);
        
        
        // 2. Act - call the method under test.
        List<CategoryDTO> dtoList = categoryService.getAllCategories();
        
        
        // 3. Assert - verify the results.
        assertEquals(3, dtoList.size(), "Should return two categories");
        verify(categoryRepository,times(1)).findAll(); // this will call the mocked object categoryRepository's findAll method once.
        // with this we are able to verify list of categories returned by the service method.
        
    }
    
    @Test
    @DisplayName("Should return empty list when no categories exist")
    void getAllCategories_shouldReturnEmptyListWhenNoCategoriesExist() throws IOException {
        // Arrange
        when(categoryRepository.findAll()).thenReturn(new ArrayList<>());
        
        // Act
        List<CategoryDTO> dtoList = categoryService.getAllCategories();
        
        // Assert
        assertEquals(0, dtoList.size(), "Should return an empty list");
        verify(categoryRepository, times(1)).findAll();
    }
    
    @Test
    @DisplayName("Should create a new category successfully")
    void createCategory_shouldCreateNewCategory() throws IOException {
        // Arrange
        
        /*
        Can remove this when we add the @BeforeEach method.
        
        CategoryDTO categoryDTO = CategoryDTO.builder().name("Toys").build();
        CategoryEntity categoryEntity = CategoryEntity.builder().name("Toys").build();
        categoryEntity.setId(3L);
        
         */
        
        when(categoryRepository.save(any(CategoryEntity.class))).thenReturn(categoryEntity3);
        
        // Act
        CategoryDTO createdCategory = categoryService.createCategory(categoryDTO);
        
        // Assert
        assertEquals("Toys", createdCategory.getName(), "Should create a new category with name 'Toys'");
        verify(categoryRepository, times(1)).save(any(CategoryEntity.class));
    }
    
    @Test
    @DisplayName("Should return category by name")
    void getByName_shouldReturnCategoryByName() throws Exception {
        // Arrange
        /*
        Can remove this when we add the @BeforeEach method.
        
        CategoryDTO categoryDTO = CategoryDTO.builder().name("Electronics").build();
        CategoryEntity categoryEntity = CategoryEntity.builder().name("Electronics").build();
        categoryEntity.setId(1L);
        
         */
        
        when(categoryRepository.findByName("Electronics")).thenReturn(Optional.of(categoryEntity1));
        
        // Act
        CategoryDTO foundCategory = categoryService.getCategoryByName("Electronics");
        
        // Assert
        assertEquals("Electronics", foundCategory.getName());
        verify(categoryRepository, times(1)).findByName("Electronics");
        
    }

}
