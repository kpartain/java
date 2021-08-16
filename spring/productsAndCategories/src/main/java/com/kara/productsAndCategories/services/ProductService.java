package com.kara.productsAndCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kara.productsAndCategories.models.Category;
import com.kara.productsAndCategories.models.Product;
import com.kara.productsAndCategories.repositories.CategoryRepository;
import com.kara.productsAndCategories.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepo;
	private final CategoryRepository categoryRepo;

	public ProductService(ProductRepository productRepo, CategoryRepository categoryRepo) {
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
	}

	public void addProduct(Product product) {
		productRepo.save(product);
	}

	public List<Product> getAll(){
		return (List<Product>) productRepo.findAll();
	}
	
	public Product getOne(Long id) {
		Optional<Product> product = productRepo.findById(id);
		if (product.isPresent()) {
			return product.get();
		}
		else {
			return null;
		}
	}
	
	public void update(Product product) {
		productRepo.save(product);
	}
	
	public List<Product> getAllExcept(Long categoryId) {
		List<Product> products = this.getAll();
		Optional<Category> category = categoryRepo.findById(categoryId);
		if (category.isPresent()) {
			List<Product> categoryProducts = category.get().getProducts();
			products.removeAll(categoryProducts);
			return products;
		} else {
			return null;
		}
	}

}
