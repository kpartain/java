package com.kara.productsAndCategories.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kara.productsAndCategories.models.Category;
import com.kara.productsAndCategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private final CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	public Category findCategoryById(Long categoryID) {
		Optional<Category> objectBeforeCasting = categoryRepository.findById(categoryID);
		if(objectBeforeCasting.isPresent()) {
			return objectBeforeCasting.get();
		} else {
			System.out.println("Error in Service");
			return null;
		}
	}

}
