package com.kara.productsAndCategories.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.kara.productsAndCategories.repositories.ProductRepository;

public class ProductService {
	
	private final ProductRepository productRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

}
