package com.example.demo.controllers;

import com.example.demo.Services.IProductService;
import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.ProductWithCategoryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    private final IProductService  productService;
    
    
    public ProductController(IProductService productService) {
        
        this.productService = productService;
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) throws Exception {
        ProductDTO result = this.productService.getProductById(id);
        
        return ResponseEntity.ok(result);
    }
    
    
    
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDto) {
//        ProductDTO result = this.productService.createProduct(productDto);
//
//        return ResponseEntity.ok(result);
        
        return ResponseEntity.ok(productService.createProduct(productDto));
    }
    
    @GetMapping("/expensive")
    public ResponseEntity<?> findExpensiveProducts(@RequestParam("price") double price) throws Exception {
        return ResponseEntity.ok(productService.getExpensiveProducts(price));
    }
    
    
    @GetMapping("/{id}/details")
    public ResponseEntity<ProductWithCategoryDTO> getProductWithCategory(@PathVariable Long id) throws Exception{
    
        
        ProductWithCategoryDTO  productWithCategoryDTO = productService.getProductWithCategory(id);
        
        return ResponseEntity.ok(productWithCategoryDTO);
    }
    
}
