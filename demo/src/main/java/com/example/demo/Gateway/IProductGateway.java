package com.example.demo.Gateway;

import com.example.demo.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public interface IProductGateway {

    ProductDTO getProductById(Long id) ;
    
    
}
