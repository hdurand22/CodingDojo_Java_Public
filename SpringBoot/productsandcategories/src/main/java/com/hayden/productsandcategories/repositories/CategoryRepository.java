package com.hayden.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hayden.productsandcategories.models.Category;
import com.hayden.productsandcategories.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();
	
	// Retrieves a list of all categories for a particular product
	List<Category> findAllByProducts(Product product);
	
	// Retrieves a list of any categories a particular product doesn't belong to
	List<Category> findByProductsNotContains(Product product);
	
}
