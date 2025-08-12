package com.example.demo.Services;

import com.example.demo.Repository.categoryRepository;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.CategoryEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
// This has made the mockito extension available for the test class with JUnit.
public class CategoryServiceTests {
    
    @Mock
    private categoryRepository categoryRepository;
    
    @InjectMocks
    private CategoryService categoryService;

    @Test
    @DisplayName("Should Return all Categories successfully")
    void getAllCategories_shouldReturnAllCategories() throws IOException {
        // method name should be - functionName_whatFunctionShouldDo;
    
        // Three steps
        // 1. Arrange - set up the test data, mocks, and expected results.
        
        List<CategoryEntity> categories = new ArrayList<>();
        CategoryEntity category1 = CategoryEntity.builder().name("Electronics").build();
        category1.setId(1L);
        CategoryEntity category2 = CategoryEntity.builder().name("Books").build();
        category2.setId(2L);
        
        categories.add(category1);
        categories.add(category2);
        
        when(categoryRepository.findAll()).thenReturn(categories);
        
        
        // 2. Act - call the method under test.
        List<CategoryDTO> dtoList = categoryService.getAllCategories();
        
        
        // 3. Assert - verify the results.
        assertEquals(2, dtoList.size(), "Should return two categories");
        verify(categoryRepository,times(1)).findAll(); // this will call the mocked object categoryRepository's findAll method once.
        // with this we are able to verify list of categories returned by the service method.
        
    }

}
