package com.codingdojo.productsCategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.productsCategories.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
//--------------------------------------------------------------------------------------------
// FINDS all the products from the database
//--------------------------------------------------------------------------------------------	
	List<Product> findAll();
//--------------------------------------------------------------------------------------------
// FINDS one product by ID from the database
//--------------------------------------------------------------------------------------------		
	Optional<Product> findById(Long id);
}
