package com.kara.productsAndCategories.services;

import java.util.Optional;


import org.springframework.stereotype.Service;

import com.kara.productsAndCategories.models.Category;
import com.kara.productsAndCategories.repositories.CategoryRepository;

@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public Category createCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}

	public Category findCategory(Long categoryID) {
		Optional <Category> foundOptional = categoryRepository.findById(categoryID);
		if(foundOptional.isPresent()) {
			return foundOptional.get();
		} else {
			return null;
		}
	}

}
