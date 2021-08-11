package com.kara.productsAndCategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kara.productsAndCategories.models.Category;
import com.kara.productsAndCategories.models.Product;
import com.kara.productsAndCategories.repositories.ProductRepository;
import com.kara.productsAndCategories.services.ProductService;

@Service
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	private final ProductService productService;
	
	public ProductsController(ProductService productService) {
		this.productService = productService;
	}
	//new
	@RequestMapping("/new")
	public String persistProduct() {
		return "productForm.jsp";
	}
	//post
	@RequestMapping(value="/new-post", method=RequestMethod.POST)
	public String productPostRequest(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		//check if valid...
		if(result.hasErrors()) {
			return "productsForm.jsp";
		} else {
			productService.createProduct(product);
			return "redirect:/products/new";
		}
		
	}
	
	//id
	@RequestMapping("/{productID}")
	public String showProduct(@RequestParam("productID") Long productID, Model model) {
		Product thisProduct = categoryService.findProductById(productID);
		List<Category> categoriesOfProduct = thisProduct.getCategories();
		model.addAttribute("product", thisProduct);
		model.addAttribute("categoriesOfProduct", categoriesOfProduct);
		return "productShow.jsp";
	}

}
