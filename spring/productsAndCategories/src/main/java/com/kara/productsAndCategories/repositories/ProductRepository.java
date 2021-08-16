package com.kara.productsAndCategories.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kara.productsAndCategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository <Product, Long> {
}
