package com.hayden.productsandcategories.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hayden.productsandcategories.models.Category;
import com.hayden.productsandcategories.models.Product;
import com.hayden.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	// Create
	public Product createProduct(Product p) {
		return productRepository.save(p);
	}
	
	// Read All
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	// Read One
	public Product getOneProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if (optionalProduct.isPresent()) {
			Product product = (Product) optionalProduct.get();
			return product;
		}
		else {
			return null;
		}
	}
	
	// Read Remaining Products
	public List<Product> getRemainingProducts(Category c) {
		return productRepository.findByCategoriesNotContains(c);
	}
	
	// Update product
	public Product updateProduct(Product p) {
		return productRepository.save(p);
	}
	
}
