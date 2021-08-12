package com.kara.productsAndCategories.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kara.productsAndCategories.models.Product;
import com.kara.productsAndCategories.repositories.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
		
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
