package com.example.demo.entity;

import jakarta.persistence.*; // Importing JPA annotations like @Id, @Column  used for mapping class to db
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;



import java.time.Instant; // Instant class from java time package is used to represent a point in time, typically used for timestamps.


// this is JPA annotation that is used to define base class that contains the common field
// which will be inherited and mapped by subclasses
// unlike entity it does not create a table in the database
@MappedSuperclass

// this is JPA annotation that is used to listen to entity lifecycle events
// this will automatically set the createdAt and updatedAt fields
// main files does have to be annotated with @EnableJpaAuditing
// but that is global setting for the whole application
// and this entityListener is just for this entity
@EntityListeners(AuditingEntityListener.class)

@Getter
@Setter

public class BaseEntity {
    
    @Id // this will mark the field as the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this will generate the primary key value automatically (like auto_increment in sql)
    private int id;
    
    
    @CreatedDate // this is updated only once when the entity is created
    @Column(nullable = false , updatable = false)
    private Instant createdAt;
    
    
    @LastModifiedDate // otherwise this will be updated every time the entity is updated
    @Column(nullable = false)
    private Instant updatedAt;
    
    
    
    // This method is automatically called before the entity is persisted (saved) to the database for the first time.
    @PrePersist
    public void onCreated() {
        Instant now = Instant.now();
        this.createdAt = now;
        this.updatedAt = now;
    }
    
    
    // This method is automatically called before the entity is updated in the database.
    @PreUpdate
    public void onUpdated() {
        this.updatedAt = Instant.now();
    }
    
}
