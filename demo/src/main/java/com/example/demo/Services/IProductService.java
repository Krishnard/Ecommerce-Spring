package com.example.demo.Services;

import com.example.demo.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    
    ProductDTO getProductById(Long id) throws Exception;
    
    ProductDTO createProduct(ProductDTO productDto)  ;
    
    List<ProductDTO> getExpensiveProducts(double minPrice) throws Exception;
}
