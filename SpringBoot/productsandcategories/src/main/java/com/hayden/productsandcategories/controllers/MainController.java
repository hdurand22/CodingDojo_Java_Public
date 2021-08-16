package com.hayden.productsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hayden.productsandcategories.models.Category;
import com.hayden.productsandcategories.models.Product;
import com.hayden.productsandcategories.services.CategoryService;
import com.hayden.productsandcategories.services.ProductService;

@Controller
public class MainController {
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public MainController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	// New Category Screen
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("newCategory") Category category) {
		return "/productsandcategories/newcategory.jsp";
	}
	
	// Handle POST request for a new category
	@RequestMapping(value="/categories/addCategory", method=RequestMethod.POST)
	public String addCategory(@Valid @ModelAttribute("newCategory") Category category, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("result has errors");
			return "/productsandcategories/newcategory.jsp";
		}
		else {
//			System.out.println("adding category in controller");
			categoryService.createCategory(category);
			return "redirect:/categories/new";
		}
	}
	
	// New Product Screen
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("newProduct") Product product) {
		return "/productsandcategories/newproduct.jsp";
	}
	
	// Handle POST request for a new product
	@RequestMapping(value="/products/addProduct", method=RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("newProduct") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "/productsandcategories/newproduct.jsp";
		}
		else {
			productService.createProduct(product);
			return "redirect:/products/new";
		}
	}
	
	// Product Detail Screen
	@RequestMapping("/products/{id}")
	public String productDetails(@PathVariable("id") Long id, Model model) {
		Product product = productService.getOneProduct(id);
		if (product == null ) {
			return "/productsandcategories/productdetails.jsp";
		}
		else {
			model.addAttribute("product", product);
			
			List<Category> allCategories = categoryService.getRemainingCategories(product);
			model.addAttribute("categories", allCategories);
			
			return "/productsandcategories/productdetails.jsp";
		}
	}
	
	// Handle adding a category to a product
	@PostMapping("/products/{id}") 
	public String addCategoryToProduct(@PathVariable("id") Long prodId, @RequestParam("categoryId") Long categoryId) {
		Category c = categoryService.getOneCategory(categoryId);
		Product p = productService.getOneProduct(prodId);
		
		p.getCategories().add(c);
		productService.updateProduct(p);
		
		return "redirect:/products/" + prodId;
	}
	
	// Category Detail Screen
	@RequestMapping("/categories/{id}")
	public String categoryDetails(@PathVariable("id") Long id, Model model) {
		Category category = categoryService.getOneCategory(id);
		if (category == null) {
			return "/productsandcategories/categorydetails.jsp";
		}
		else {
			model.addAttribute("category", category);
			List<Product> allProducts = productService.getRemainingProducts(category);
			model.addAttribute("products", allProducts);
			return "/productsandcategories/categorydetails.jsp";
		}
	}
	
	// Handle adding a product to a category
	@PostMapping("/categories/{id}")
	public String addProductToCategory(@PathVariable("id") Long categoryId, @RequestParam("productId") Long productId) {
		Category c = categoryService.getOneCategory(categoryId);
		Product p = productService.getOneProduct(productId);
		c.getProducts().add(p);
		categoryService.updateCategory(c);
		
		return "redirect:/categories/" + categoryId;
	}
	
}
