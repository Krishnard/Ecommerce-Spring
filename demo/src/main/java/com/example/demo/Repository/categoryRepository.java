package com.example.demo.Repository;

import com.example.demo.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface categoryRepository extends JpaRepository<CategoryEntity,Long> {
    
    
    // Find Category by name
    Optional<CategoryEntity> findByName(String name) throws Exception;
}
