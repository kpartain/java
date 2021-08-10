package com.kara.productsAndCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kara.productsAndCategories.models.Category;
import com.kara.productsAndCategories.models.Product;

public interface ProductRepository extends CrudRepository <Product, Long> {
}
