package com.kara.productsAndCategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kara.productsAndCategories.models.Category;
import com.kara.productsAndCategories.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository <Category, Long> {
	Optional<Category> findById(Long id);
	
    List<Category> findAllByProducts(Product product);

    List<Category> findByProductsNotContains(Product product);

}
