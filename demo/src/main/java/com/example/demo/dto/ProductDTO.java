package com.example.demo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.example.demo.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

	@NotBlank(message = "Tên sản phẩm không được để trống")
	private String productName;

	@Min(value = 1, message = "Giá phải lớn hơn hoặc bằng 1")
	private double price;

	private String note;

	public Product toEntity() {
		Product p = new Product();
		p.setProductName(this.productName);
		p.setPrice(this.price);
		p.setNote(this.note);
		return p;
	}

	public static ProductDTO fromEntity(Product p) {
		ProductDTO dto = new ProductDTO();
		dto.setProductName(p.getProductName());
		dto.setPrice(p.getPrice());
		dto.setNote(p.getNote());
		return dto;
	}

}
