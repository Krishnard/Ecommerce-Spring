package com.example.demo.dto;

import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProductDTO{
	
	private String image;
	private String color;
	private int price;
	private String description;
	private int discount;
	private String model;
	private Long id;
	private String title;
	
    // private String category;
	// to do JPA Relationship Mapping
	// we will make category as a CategoryId - Long datatype
	private Long categoryId;
	
	private String brand;
	private boolean popular;
}