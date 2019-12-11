package com.codingdojo.productsCategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.productsCategories.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
//--------------------------------------------------------------------------------------------
// FINDS all the categories from the database
//--------------------------------------------------------------------------------------------	
	List<Category> findAll();
//--------------------------------------------------------------------------------------------
// FINDS one category by ID from the database
//--------------------------------------------------------------------------------------------	
	Optional<Category> findById(Long id);
}
