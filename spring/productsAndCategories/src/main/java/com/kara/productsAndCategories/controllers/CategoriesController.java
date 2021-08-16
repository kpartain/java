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
import com.kara.productsAndCategories.services.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoriesController {
	private final CategoryService categoryService;
	
	public CategoriesController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	@RequestMapping("")
	public String redirectToNeww(@ModelAttribute("category")Category category) {
		return "categoryForm.jsp";
	}
	@RequestMapping("/")
	public String redirectToNewTooo(@ModelAttribute("category")Category category) {
		return "categoryForm.jsp";
	}
	//new
	@RequestMapping("/new")
	public String persistCategory(@ModelAttribute("category")Category category) {
		return "categoryForm.jsp";
	}
	//post
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String categoryPostRequest(@Valid @ModelAttribute("category")Category category, BindingResult result) {
		//check if valid...
		if(result.hasErrors()) {
			return "categoriesForm.jsp";
		} else {
			Category thisCat = categoryService.createCategory(category);
			return "redirect:/categories/new";
		}
	}
	
	//id
	@RequestMapping("/{id}")
	public String showCategory(@RequestParam("id")Long categoryID, Model model) {
		Category thisCategory = categoryService.findCategoryById(categoryID);
		model.addAttribute("category", thisCategory);
		return "categoryShow.jsp";
	}
}
