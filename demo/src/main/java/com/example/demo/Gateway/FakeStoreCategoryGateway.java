package com.example.demo.Gateway;

import com.example.demo.Gateway.api.FakeStoreCategoryApi;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.FakeStoreCategoryResponseDTO;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreCategoryGateway implements ICategoryGateway {
    
    private final FakeStoreCategoryApi fakeStoreCategoryApi;
    
    public FakeStoreCategoryGateway(FakeStoreCategoryApi fakeStoreCategoryApi) {
        this.fakeStoreCategoryApi = fakeStoreCategoryApi;
    }
    
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        
        
        FakeStoreCategoryResponseDTO responseDTO =  this.fakeStoreCategoryApi.getAllFakeCategories()
                .execute()
                .body();
        
        if (responseDTO == null){
            throw new IOException ("Failed to fetch categories from fake store.");
        }
        return responseDTO.getCategories().stream().map(category -> CategoryDTO.builder().name(category).build()).toList();
        
    }
}
