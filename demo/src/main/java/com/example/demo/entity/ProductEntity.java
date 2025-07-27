package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity extends BaseEntity {
    
    private String image;
    private String color;
    private int price;
    private String description;
    private int discount;
    private String model;
    private String title;
//    private String category;
    private String brand;
    private boolean popular;
    
    @ManyToOne // multiple products can be associated to one category // or we can say as one category can have multiple products
    @JoinColumn(name = "categoryId") // this will create a foreign key column in the product table // never be null
    private CategoryEntity category; // Assuming Category is another entity class that you have defined
    
}
