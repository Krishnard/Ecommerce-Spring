package com.example.demo.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
    
    @GetMapping
    public String getCategory(){
        return "Hello strings";
    }
    
    
    @PostMapping
    public String getPostCategory(){
        return "Hello strings POST request";
    }
    
    
    @GetMapping("/count") // if we call a GET request on /api/categories/count
    public int getCategoryCount(){
        return 10;
    }
    
    
    @DeleteMapping
    public String deleteCategory(){
        return "Category deleted";
    }
}
