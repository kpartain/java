package com.kara.productsAndCategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kara.productsAndCategories.models.Category;
import com.kara.productsAndCategories.models.Product;
import com.kara.productsAndCategories.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductsController {
	
	private final ProductService productService;

	public ProductsController(ProductService productService) {
		this.productService = productService;
	}
	@RequestMapping("")
	public String redirectToNew(@ModelAttribute("product")Product product) {
		return "productForm.jsp";
	}
	@RequestMapping("/")
	public String redirectToNewToo(@ModelAttribute("product")Product product) {
		return "productForm.jsp";
	}
	//new
	@RequestMapping("/new")
	public String persistProduct(@ModelAttribute("product")Product product) {
		return "productForm.jsp";
	}
	//post
	@RequestMapping(value="/new", method=RequestMethod.POST)
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
	public String showProduct(@PathVariable("productID") Long productID, Model model) {
		Product thisProduct = productService.findProduct(productID);
		model.addAttribute("product", thisProduct);
		model.addAttribute("categoriesOfProduct", thisProduct.getCategories());
		return "productShow.jsp";
	}

}
