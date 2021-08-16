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
@RequestMapping("/products")
public class ProductsController {
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public ProductsController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@RequestMapping("/new")
	public String newProductPageRender(Model model, @ModelAttribute("product") Product product) {
		return "productForm.jsp";
	}
	
	@PostMapping("/new")
	public String addNewProductPOST(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Category> categories = categoryService.getAll();
			model.addAttribute("categories", categories);
			return "redirect:/products/new";
		} else {
			productService.addProduct(product);
			return "redirect:/products/new";
		}
	}
	
	@RequestMapping("/{id}")
	public String showSingleCategory(Model model, @PathVariable("id") Long id) {
		Product product = productService.getOne(id);
		model.addAttribute("product", product);
		model.addAttribute("categories", categoryService.getAllExcept(id));
		return "productsShow.jsp";
	}
	
	@PostMapping("/{id}")
	public String addCategoryToProduct(@PathVariable("id") Long productId, @RequestParam("category") Long categoryId) {
		Product product = productService.getOne(productId);
		Category category = categoryService.getOne(categoryId);
		List<Category> categories = product.getCategories();
		categories.add(category);
		productService.update(product);
		return "redirect:/products/"+productId;
	}

}
