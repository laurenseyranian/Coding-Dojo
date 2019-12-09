package com.codingdojo.productsCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.productsCategories.models.Category;
import com.codingdojo.productsCategories.models.CategoryProduct;
import com.codingdojo.productsCategories.models.Product;
import com.codingdojo.productsCategories.repositories.CategoryProductRepository;
import com.codingdojo.productsCategories.repositories.CategoryRepository;
import com.codingdojo.productsCategories.repositories.ProductRepository;

@Service
public class CategoryProductService {
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	private final CategoryProductRepository categoryProductRepository;
	
	public CategoryProductService(CategoryRepository categoryRepository, ProductRepository productRepository, CategoryProductRepository categoryProductRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
		this.categoryProductRepository = categoryProductRepository;
	}


////CREATES one Category//////////////////////////////////////////////////////////////////////
	public Category createCategory(Category createCategory) {
		return categoryRepository.save(createCategory);
	}
////CREATES one Product/////////////////////////////////////////////////////////////////////
    public Product createProduct(Product createProduct) {
        return productRepository.save(createProduct);
    }
////ADDING a Category to a Product or vice-versa////////////////////////////////////////////////
    public CategoryProduct addProductOrCategory(CategoryProduct categoryProduct) {
        return categoryProductRepository.save(categoryProduct);
    }  
////RETRIEVES one Category by ID////////////////////////////////////////////////////////////// 
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}
////RETRIEVES one Product by ID////////////////////////////////////////////////////////////// 
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}
////RETRIEVES all Products////////////////////////////////////////////////////////////////// 
	public List<Product> allProducts() {
		productRepository.findAll();
		return productRepository.findAll();
	}
////RETRIEVES all Categories////////////////////////////////////////////////////////////////// 
	public List<Category> allCategories() {
		categoryRepository.findAll();
		return categoryRepository.findAll();
	}
}
