package com.kara.productsAndCategories.services;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.kara.productsAndCategories.models.Category;
import com.kara.productsAndCategories.models.Product;
import com.kara.productsAndCategories.repositories.CategoryRepository;
import com.kara.productsAndCategories.repositories.ProductRepository;

@Service
public class CategoryService {
	private final ProductRepository productRepo;
	private final CategoryRepository categoryRepo;
	
	public CategoryService(CategoryRepository categoryRepo, ProductRepository productRepo) {
		this.categoryRepo = categoryRepo;
		this.productRepo = productRepo;
	}
	
	public void addCategory(Category category) {
		categoryRepo.save(category);
	}

	public List<Category> getAll() {
		return (List<Category>) categoryRepo.findAll();
	}
	
	public Category getOne(Long id) {
		Optional<Category> category = categoryRepo.findById(id);
		if (category.isPresent()) {
			return category.get();
		}
		else {
			return null;
		}
	}
	

	public void update(Category category) {
		categoryRepo.save(category);
	}
	
	public List<Category> getAllExcept(Long productId) {
		List<Category> categories = this.getAll();
		Optional<Product> product = productRepo.findById(productId);
		if (product.isPresent()) {
			List<Category> productCategories = product.get().getCategories();
			categories.removeAll(productCategories);
			return categories;
		} else {
			return null;
		}
	}

}
