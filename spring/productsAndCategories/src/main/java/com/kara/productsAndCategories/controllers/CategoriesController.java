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
import com.kara.productsAndCategories.repositories.CategoryRepository;
import com.kara.productsAndCategories.services.CategoryService;

@Service
@RequestMapping("/categories")
public class CategoriesController {
	
	@Autowired
	private final CategoryService categoryService;
	
	public CategoriesController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	//new
	@RequestMapping("/new")
	public String persistCategory(l) {
		return "categoryForm.jsp";
	}
	//post
	@RequestMapping(value="/new-post", method=RequestMethod.POST)
	public String categoryPostRequest(@Valid @ModelAttribute("category")Category category, BindingResult result) {
		//check if valid...
		if(result.hasErrors()) {
			return "categoriesForm.jsp";
		} else {
			categoryService.createCategory(category);
			return "redirect:/categories/new";
		}
	}
	
	//id
	@RequestMapping("/{categoryID}")
	public String showCategory(@RequestParam("categoryID")Long categoryID, Model model) {
		Category thisCategory = categoryService.findCategoryById(categoryID);
		List<Product> productsInCategory = thisCategory.getProducts();
		model.addAttribute("category", thisCategory);
		model.addAttribute("productsInCategory", thisCategory);
		return "categoryShow.jsp";
	}
}
