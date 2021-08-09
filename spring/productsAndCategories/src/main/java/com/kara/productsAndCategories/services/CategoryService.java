package com.kara.productsAndCategories.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.kara.productsAndCategories.repositories.CategoryRepository;

public class CategoryService {
	
	private final CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

}
