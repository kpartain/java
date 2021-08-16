package com.kara.productsAndCategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kara.productsAndCategories.models.Category;
import com.kara.productsAndCategories.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository <Category, Long> {
	//find by ID
	Optional<Category> findById(Long id);
	
	//save
	Optional<Category> create(Category category);
	
	 // Retrieves a list of all categories for a particular product
    List<Category> findAllByProducts(Product product);
    
    // Retrieves a list of any categories a particular product
    // does not belong to.
    List<Category> findByProductsNotContains(Product product);

}
