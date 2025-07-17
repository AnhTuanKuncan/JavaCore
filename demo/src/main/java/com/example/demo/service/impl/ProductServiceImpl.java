package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<ProductDTO> getAllProducts() {
		return productRepository.findAll().stream().map(ProductDTO::fromEntity).collect(Collectors.toList());
	}

	@Override
	public ProductDTO getProductById(Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
		return ProductDTO.fromEntity(product);
	}

	@Override
	public ProductDTO createProduct(ProductDTO productDto) {
		Product saved = productRepository.save(productDto.toEntity());
		return ProductDTO.fromEntity(saved);
	}

	@Override
	public ProductDTO updateProduct(Long id, ProductDTO productDto) {
		Product existing = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

		existing.setProductName(productDto.getProductName());
		existing.setPrice(productDto.getPrice());
		existing.setNote(productDto.getNote());

		Product updated = productRepository.save(existing);
		return ProductDTO.fromEntity(updated);
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
