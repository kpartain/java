package com.kara.productsAndCategories.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kara.productsAndCategories.models.Category;
import com.kara.productsAndCategories.models.Product;
import com.kara.productsAndCategories.services.CategoryService;
import com.kara.productsAndCategories.services.ProductService;

@Controller
@RequestMapping("/categories")
public class CategoriesController  {
	
	private final ProductService productService;
	private final CategoryService categoryService;

	public CategoriesController(CategoryService categoryService, ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}
	
	@RequestMapping("/new")
	public String newCategoryPageRender(Model model, @ModelAttribute("category") Category category) {
		return "categoryForm.jsp";
	}
	
	@PostMapping("/new")
	public String addNewCategoryPOST(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Product> products = productService.getAll();
			model.addAttribute("products", products);
			return "redirect:/categories/new";
		} else {
			categoryService.addCategory(category);
			return "redirect:/categories/new";
		}
	}
	
	@RequestMapping("/{id}")
	public String showSingleCategory(Model model, @PathVariable("id") Long id) {
		Category category = categoryService.getOne(id);
		model.addAttribute("category", category);
		model.addAttribute("products", productService.getAllExcept(id));
		return "categoriesShow.jsp";
	}
	
	@PostMapping("/{id}")
	public String addProductToCategory(@PathVariable("id") Long categoryId, @RequestParam("product") Long productId) {
		Category category = categoryService.getOne(categoryId);
		Product product = productService.getOne(productId);
		List<Product> products = category.getProducts();
		products.add(product);
		categoryService.update(category);
		return "redirect:/categories/"+categoryId;
	}
}
