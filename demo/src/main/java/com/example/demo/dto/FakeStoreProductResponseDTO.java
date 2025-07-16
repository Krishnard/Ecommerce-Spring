package com.example.demo.dto;

import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class FakeStoreProductResponseDTO {
	private ProductDTO product;
	private String message;
	private String status;
}