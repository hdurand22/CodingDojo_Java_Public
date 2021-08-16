package com.hayden.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hayden.productsandcategories.models.Category;
import com.hayden.productsandcategories.models.Product;
import com.hayden.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	// Create
	public Category createCategory(Category c) {
//		System.out.println("saving category in service");
		return categoryRepository.save(c);
	}
	
	// Read All
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}
	
	// Read One
	public Category getOneCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if (optionalCategory.isPresent()) {
			Category category = (Category) optionalCategory.get();
			return category;
		}
		else {
			return null;
		}
	}
	
	// Read remaining categories
	public List<Category> getRemainingCategories(Product p) {
		return categoryRepository.findByProductsNotContains(p);
	}
	
	// Update category
	public Category updateCategory(Category c) {
		return categoryRepository.save(c);
	}
}
