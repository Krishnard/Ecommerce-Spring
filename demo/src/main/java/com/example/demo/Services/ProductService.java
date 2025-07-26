package com.example.demo.Services;

import com.example.demo.Repository.productRepository;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.ProductEntity;
import com.example.demo.mappers.productMapper;
import org.springframework.stereotype.Service;


@Service
public class ProductService implements IProductService {

    private final productRepository productRepository;
    
    public ProductService(productRepository productRepository) {
        
        this.productRepository = productRepository;
        
    }
    
    

    
    public ProductDTO getProductById(Long id) throws Exception {
//        return productRepository.findById(id)
//                .map(productMapper::toDTO)
//                .orElseThrow(() -> new Exception("Product not found."));
    
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new Exception("Product not found.")); // Find the entity by ID
        
        return productMapper.toDTO(productEntity); // Convert the entity to DTO and return it
    
    }
    
    
    @Override
    public ProductDTO createProduct(ProductDTO productDto) {
        ProductEntity productEntity = productMapper.toEntity(productDto); // Convert DTO to Entity
        
        ProductEntity productEntitySaved = productRepository.save(productEntity); // Save the entity
        
        ProductDTO productDTO = productMapper.toDTO(productEntitySaved); // Convert saved entity back to DTO
        
        
        return productDTO; // return the DTO
        
//        ProductEntity productSaved =  productRepository.save(productMapper.toEntity(productDto));
//        return productMapper.toDTO(productSaved);
    }
}
