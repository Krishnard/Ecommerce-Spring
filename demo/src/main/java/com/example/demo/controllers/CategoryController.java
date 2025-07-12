package com.example.demo.controllers;


import com.example.demo.Services.FakeStoreCategoryServices;
import com.example.demo.Services.ICategoryService;
import com.example.demo.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
    
    // private FakeStoreCategoryServices categoryServices;
    // if later further in project it will have to changes deu to changes in services
    // for ex. SQLCategoryService or something like that
    //therefore, this violates the dependency inversion principle (DIP) -  we should not directly depend on concrete class
    // need to create an abstraction
    
    // now our class is dependent on interface so there is no issue
    
    
    // @Autowired
    private final ICategoryService CategoryService; // @Autowired doesn't support final keyword
    
    
    // constructor
    // now here we have assigned our iCategoryService an object
    // so whenever spring call the constructor of CategoryController it has to pass the obj. which is
    // compatible to ICategoryService
    // it will check whether we have implementation of ICategoryService
    // yes we have implementation of ICategoryService as a FakeStoreCategoryService
    // so create obj of that class and inject it automatically
    // and this whole thing is called as
    // Dependency Injection - object receives it dependencies from external source rather than creating it
    // Spring is providing us Dependency Injection capability with use of this we are simplifying implementation of dependency inversion principle
    
     CategoryController(ICategoryService CategoryService) {
        this.CategoryService = CategoryService;
    }

    // this was a first way to do this
    
    // second way to do this is using @autowired
    
    
    
    @GetMapping
    public List<CategoryDTO> getAllCategories() throws IOException {
        // It must not contain any business logic
        // It should only call the service layer fot that
        
        return this.CategoryService.getAllCategories() ;
    }
}



// new Cate