package com.kara.productsAndCategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kara.productsAndCategories.models.Product;
import com.kara.productsAndCategories.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductsController {
	
	private final ProductService productService;
	
	public ProductsController(ProductService productService) {
		this.productService = productService;
	}
	//new
	@RequestMapping("/new")
	public String persistProduct(@ModelAttribute("product") Product product) {
		return "productForm.jsp";
	}
	//post
	@RequestMapping(value="/new-post", method=RequestMethod.POST)
	public String productPostRequest(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		//check if valid...
		if(result.hasErrors()) {
			return "productsForm.jsp";
		} else {
			Product thisProd = productService.createProduct(product);
			return "redirect:/products/new";
		}
		
	}
	
	//id
	@RequestMapping("/{id}")
	public String showProduct(@RequestParam("id") Long id, Model model) {
		Product thisProduct = productService.findProductById(id);
		model.addAttribute("product", thisProduct);
		return "productShow.jsp";
	}

}
