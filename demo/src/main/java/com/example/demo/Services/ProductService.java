package com.example.demo.Services;

import com.example.demo.Gateway.IProductGateway;
import com.example.demo.dto.ProductDTO;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    private IProductGateway productGateway;
    
    public ProductService(IProductGateway productGateway) {
        this.productGateway = productGateway;
    }
    
    @Override
    public ProductDTO getProductById(Long id) throws Exception {
        return productGateway.getProductById(id);
    }
}
