package com.example.demo.Gateway;

import com.example.demo.dto.CategoryDTO;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public interface ICategoryGateway {
    
    List<CategoryDTO> getAllCategories() throws IOException;
}
