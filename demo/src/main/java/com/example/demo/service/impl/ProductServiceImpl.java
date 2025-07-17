package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
	}

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);

	}

	@Override
	public Product updateProduct(Long id, Product product) {
		Product existing = getProductById(id);
		existing.setProductName(product.getProductName());
		existing.setPrice(product.getPrice());
		existing.setNote(product.getNote());
		return productRepository.save(existing);
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
		;

	}

}
