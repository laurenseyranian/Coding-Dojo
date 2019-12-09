package com.codingdojo.productsCategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.productsCategories.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
////Retrieves ALL the products from the database
	List<Category> findAll();
////Retrieves one product by ID from the database
	Optional<Category> findById(Long id);
}
