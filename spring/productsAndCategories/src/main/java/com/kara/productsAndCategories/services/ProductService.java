package com.kara.productsAndCategories.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.stereotype.Service;

import com.kara.productsAndCategories.models.Product;
import com.kara.productsAndCategories.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}


	public Product findProductById(Long productID) {
		Optional<Product> prodBeforeCast = productRepository.findById(productID);
		if(prodBeforeCast.isPresent()) {
			return prodBeforeCast.get();
		} else {
			System.out.println("Not found in service");
			return null;
		}

	public Product findProduct(Long productID) {
		Optional <Product> foundOptional = productRepository.findById(productID);
		if(foundOptional.isPresent()) {
			return foundOptional.get();
		} else {
			return null;
		}
	}

}
