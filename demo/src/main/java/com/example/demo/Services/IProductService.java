package com.example.demo.Services;

import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.ProductWithCategoryDTO;

import java.util.List;

public interface IProductService {
    
    ProductDTO getProductById(Long id) throws Exception;
    
    ProductDTO createProduct(ProductDTO productDto)  ;
    
    List<ProductDTO> getExpensiveProducts(double minPrice) throws Exception;
    
    ProductWithCategoryDTO getProductWithCategory(Long id) throws Exception;
}
