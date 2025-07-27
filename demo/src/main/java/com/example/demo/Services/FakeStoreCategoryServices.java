package com.example.demo.Services;

import com.example.demo.Gateway.ICategoryGateway;
import com.example.demo.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreCategoryServices implements ICategoryService {
    
    
    private final ICategoryGateway categoryGateway;
    
    public FakeStoreCategoryServices(@Qualifier("fakeStoreRestTemplateGateway") ICategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }
    
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return this.categoryGateway.getAllCategories();
    }
    
    public CategoryDTO createCategory(CategoryDTO categoryDto) {
        return null;
    }
    
    public CategoryDTO getCategoryByName(String name) throws Exception {
        return null;
    }
}
