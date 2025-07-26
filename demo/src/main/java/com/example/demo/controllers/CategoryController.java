package com.example.demo.controllers;

import com.example.demo.Services.ICategoryService;
import com.example.demo.dto.CategoryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    
    
    // Using interface instead of concrete class (e.g., FakeStoreCategoryServices) follows
    // the Dependency Inversion Principle (DIP) – depend on abstractions, not implementations.
    // This allows us to switch the service implementation later (e.g., SQLCategoryService) without changing controller logic.
    
    
    // 2 ways to implement dependency injection in Spring: 1. @Autowired annotation, 2. Constructor Injection
    // Constructor Injection is the recommended way in Spring as it makes the code more testable and easier to manage.
    
    // @Autowired
    private final ICategoryService CategoryService; // @Autowired doesn't support final keyword
    
    // Constructor Injection (Recommended way in Spring)
    // Spring will automatically inject a bean that implements ICategoryService
    // This is a part of Dependency Injection (DI) -object receives it dependencies from external source rather than creating it
    // It helps decouple the controller from specific service implementations
    
    
     CategoryController(   ICategoryService CategoryService) {
        this.CategoryService = CategoryService;
    }
    
    
    
    /*
    @GetMapping
    public List<CategoryDTO> getAllCategories() throws IOException {
        // It must not contain any business logic
        // It should only call the service layer fot that
        
        return this.CategoryService.getAllCategories() ;
    }
     */
    
    // we're trying to use reponseentity that is used to manipulate the HTTP response
    
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() throws IOException {
        
         // List<CategoryDTO> responseResult = this.CategoryService.getAllCategories();
        
        // return ResponseEntity with status code 200 OK and the list of categories
//        return ResponseEntity.ok(responseResult);
        
        
        // this will return a 201 Created status code
        // return ResponseEntity.created(null).body(responseResult);
    
        List<CategoryDTO> categories = CategoryService.getAllCategories();
        return ResponseEntity.ok(categories);
        
    }
    
    
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDto) {
        // This method is used to create a new category
        
        return ResponseEntity.ok(CategoryService.createCategory(categoryDto));
        
    }
    
}

