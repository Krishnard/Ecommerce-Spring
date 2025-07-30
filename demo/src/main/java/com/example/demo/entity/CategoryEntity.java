package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "category")
public class CategoryEntity extends BaseEntity {
    
    // id is imported from BaseEntity // no need to specify it again here
    
    @Column(nullable = false,unique = true)
    private String name;
    
    
    // One category can have multiple products // each product compulsorily belongs to one category
    @OneToMany(mappedBy = "category"   // Assuming ProductEntity has a field named 'category' of type CategoryEntity
            // mappedBy indicates that this is the inverse side (both way) of the relationship
            , fetch = FetchType.LAZY)   // FetchType.Lazy means products will be loaded lazily, i.e., only when accessed or only when needed
    
    private List<ProductEntity> products; // Assuming ProductEntity is another entity class that you have defined
    
    // always try to read as one category can have many products
    
}
