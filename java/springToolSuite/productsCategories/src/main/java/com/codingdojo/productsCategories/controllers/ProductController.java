package com.codingdojo.productsCategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.productsCategories.models.Category;
import com.codingdojo.productsCategories.models.CategoryProduct;
import com.codingdojo.productsCategories.models.Product;
import com.codingdojo.productsCategories.services.CategoryProductService;

@Controller
public class ProductController {
	
////Attributes(Controllers need Service Attributes in order to access info from the Service)
	private final CategoryProductService categoryProductService;
	public ProductController(CategoryProductService categoryProductService) {
		//Creating an instance from the Service??		
		this.categoryProductService = categoryProductService;
	}
////Route for CREATING a new Product///////////////////////////////////////////////////////////////////////////	
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product, Model model) {
		return "/categoryProduct/createProduct.jsp";
	}
////POST route for CREATING a new Product/////////////////////////////////////////////////////////////////////// 	
	@RequestMapping(value = "/product/process", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("product") Product createProduct, BindingResult result) {
		if (result.hasErrors()) {
			return "/categoryProduct/createProduct.jsp";
		} else {
			categoryProductService.createProduct(createProduct);
			return "redirect:/products/" + createProduct.getId();
		}
	}
////Route for READING one Product by ID//////////////////////////////////////////////////////////////////////////	
	@GetMapping("/products/{product_id}")
	public String getPerson(@PathVariable("product_id") Long id, Model model, @ModelAttribute("productCategory") CategoryProduct categoryProduct) { 
		model.addAttribute("product", categoryProductService.findProduct(id));
		List<Category> categories = categoryProductService.allCategories();
		model.addAttribute("categories", categories);
		return "/categoryProduct/readOneProduct.jsp";
	}
////Route for ADDING a Product to a Category on Products Page/////////////////////////////////////////////////////
	@RequestMapping("/addProductToCategory")
	public String addCategory(@ModelAttribute("productCategory") CategoryProduct categoryProduct, Model model) {
		categoryProductService.addProductOrCategory(categoryProduct);
		return "redirect:/products/" + categoryProduct.getProduct().getId();
	}
}
