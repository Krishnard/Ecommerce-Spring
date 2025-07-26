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
	private String category;
	private String brand;
	private boolean popular;
}