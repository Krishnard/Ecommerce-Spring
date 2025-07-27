package com.example.demo.Repository;

import com.example.demo.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface productRepository extends JpaRepository<ProductEntity,Long> {
    
    
    // Return the products that are expensive or return all products which are > than specified price
    
    
    // This is custom query method using HQL
    // Explicitly define the query
    @Query("SELECT p FROM ProductEntity p WHERE p.price > :minPrice") // this is HQL query // here price is java field // this is not a column name in database
    List<ProductEntity> findExpensiveProducts(@Param("minPrice") double minPrice);
    // optional returns only one record - unlike list
    // can be considered as coming to hibernate layer
    
    
    
    
    // what if I wanted to use even complex queries like LIMIT , REGEXP , LIKE, etc.?
    // In that case, you can use the @Query annotation with native SQL queries or HQL queries.
    // when u use native sql query - - raw sql query is used
    // literally using JDBC - - level lower than hibernate
    @Query(value="SELECT * FROM product_entity p WHERE MATCH(name,description) AGAINST(:keyword)" , nativeQuery = true)
    List<ProductEntity> searchProductsByKeyword(@Param("keyword") String keyword);
    
    // JPA query - documentation - read for all in-build queries
    
    // try to implement this searchProductByKeyword
    
    

}
