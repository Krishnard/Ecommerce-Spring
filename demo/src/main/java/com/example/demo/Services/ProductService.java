package com.example.demo.Services;

import com.example.demo.Repository.categoryRepository;
import com.example.demo.Repository.productRepository;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.CategoryEntity;
import com.example.demo.entity.ProductEntity;
import com.example.demo.mappers.productMapper;
import org.springframework.stereotype.Service;


@Service
public class ProductService implements IProductService {

    private final productRepository productRepository;
    
    private final categoryRepository categoryRepository;
    
    public ProductService(productRepository productRepository, categoryRepository categoryRepository) {
        
        this.productRepository = productRepository;
        
        this.categoryRepository = categoryRepository;
        
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
        CategoryEntity categoryEntity = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found")); // Find the category entity by ID
        // this is to ensure that the category exists before creating the product
        
        ProductEntity productEntity = productMapper.toEntity(productDto,categoryEntity); // Convert DTO to Entity
        // also added categoryEntity as a parameter as we have to set the category entity directly in the product entity
        
        ProductEntity productEntitySaved = productRepository.save(productEntity); // Save the entity
        
        ProductDTO productDTO = productMapper.toDTO(productEntitySaved); // Convert saved entity back to DTO
        
        
        return productDTO; // return the DTO
        
//        ProductEntity productSaved =  productRepository.save(productMapper.toEntity(productDto));
//        return productMapper.toDTO(productSaved);
    }
}
