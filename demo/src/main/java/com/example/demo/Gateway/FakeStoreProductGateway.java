package com.example.demo.Gateway;

import com.example.demo.Gateway.IProductGateway;
import com.example.demo.Gateway.api.FakeStoreProductApi;
import com.example.demo.dto.FakeStoreProductResponseDTO;
import com.example.demo.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class FakeStoreProductGateway implements IProductGateway {
    
    private FakeStoreProductApi fakeStoreProductApi;
    
    public FakeStoreProductGateway(FakeStoreProductApi fakeStoreProductApi) {
        this.fakeStoreProductApi = fakeStoreProductApi;
    }

    @Override
    public ProductDTO getProductById(Long id) throws Exception {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = this.fakeStoreProductApi.getFakeProduct(id).execute().body();
        
        if (fakeStoreProductResponseDTO == null || fakeStoreProductResponseDTO.getProduct() == null) {
            throw new Exception("Product not found");
        }
        
        return fakeStoreProductResponseDTO.getProduct();
    }
}
