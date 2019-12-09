package com.codingdojo.productsCategories.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.productsCategories.models.CategoryProduct;

public interface CategoryProductRepository extends CrudRepository<CategoryProduct, Long>{

}
