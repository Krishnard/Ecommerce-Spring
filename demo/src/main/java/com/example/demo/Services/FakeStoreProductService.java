package com.example.demo.Services;

import com.example.demo.Gateway.IProductGateway;
import com.example.demo.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreProductService implements IProductService {

    private IProductGateway productGateway;
    
    public FakeStoreProductService(IProductGateway productGateway) {
        this.productGateway = productGateway;
    }
    
    @Override
    public ProductDTO getProductById(Long id) throws Exception {
        return productGateway.getProductById(id);
    }
    
    @Override
    public ProductDTO createProduct(ProductDTO productDto)  {
        return null;
    }
    
    
    public List<ProductDTO> getExpensiveProducts(double price) throws Exception{
        return null;
    }
}
