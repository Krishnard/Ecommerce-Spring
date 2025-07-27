package com.example.demo.Services;

import com.example.demo.dto.ProductDTO;

public interface IProductService {
    
    ProductDTO getProductById(Long id) throws Exception;
    
    ProductDTO createProduct(ProductDTO productDto)  ;
}
