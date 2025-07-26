package com.example.demo.Gateway;

import com.example.demo.dto.CategoryDTO;
//import org.springframework.context.annotation.Primary;
import com.example.demo.dto.FakeStoreCategoryResponseDTO;

//
import com.example.demo.mappers.getAllCategoriesMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Component("fakeStoreRestTemplateGateway")
//@Primary

public class FakeStoreRestTemplateGateway implements ICategoryGateway {
    
    // this whole method is working, and also we can do as the second method using rest-builder as well
    
    /*
    private final RestTemplate restTemplate;

    public FakeStoreRestTemplateGateway(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {

        String baseUrl = "https://fakestoreapi.in/api/products/category";

        // 1. Make the request to the Fake Store API using RestTemplate
        ResponseEntity<FakeStoreCategoryResponseDTO> responseEntity = restTemplate.
                getForEntity(baseUrl, FakeStoreCategoryResponseDTO.class
                );

        // 2. Check if the response is successful and contains data
        if (responseEntity.getBody() == null) {
            throw new IOException("Failed to fetch categories from fake store.");
        }

        // 3. Map the response to a list of CategoryDTO
//        return responseEntity.getBody().
//                getCategories().
//                stream().
//                map(category -> CategoryDTO.builder().name(category).build()).
//                toList();
//

        return getAllCategoriesMapper.toCategoryDTO(responseEntity.getBody());
        // this uses the mapper to convert the response DTO to a list of CategoryDTO
        // mapper is just a utility class that converts the response DTO to a list of CategoryDTO --> helps in conversion
    }
    */
    
    private final RestTemplateBuilder restTemplateBuilder;
    
    public FakeStoreRestTemplateGateway(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    
    @Value("${fakeStore.baseUrl}")
    private String fakeBaseUrl; // this will be used to get the base URL from application.properties
    
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        
        RestTemplate restTemplate = restTemplateBuilder.build();
        
        
        ResponseEntity<FakeStoreCategoryResponseDTO> responseEntity = restTemplate.
                getForEntity(
                        fakeBaseUrl+"products/category", FakeStoreCategoryResponseDTO.class
                );
        
        if (responseEntity.getBody() == null) {
            throw new IOException("Failed to fetch categories from fake store.");
        }
        
//        return responseEntity.getBody()
//                .getCategories()
//                .stream()
//                .map(category -> CategoryDTO.builder().name(category).build())
//                .toList();
        
        
        // this  can be written with help of the mapper as well
        
        return getAllCategoriesMapper.toCategoryDTO(responseEntity.getBody());
        
        
    }
}