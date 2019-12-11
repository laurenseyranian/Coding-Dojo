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
public class CategoryController {
//--------------------------------------------------------------------------------------------
// Attributes(Controllers need Service Attributes in order to access info from the Service)
//--------------------------------------------------------------------------------------------	
	private final CategoryProductService categoryProductService;
	//----------------------------------------------------------------------------------------
	// Constructor Method that Makes Service apart of the instance of the Controller
	//----------------------------------------------------------------------------------------
	public CategoryController(CategoryProductService categoryProductService) {
	//----------------------------------------------------------------------------------------
	// Creating an instance from the Service
	//----------------------------------------------------------------------------------------		
		this.categoryProductService = categoryProductService;
	}
//--------------------------------------------------------------------------------------------
// GET Route for CREATING a new Product
//--------------------------------------------------------------------------------------------	
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category, Model model) {
		return "/categoryProduct/createCategory.jsp";
	}
//--------------------------------------------------------------------------------------------
// POST route for CREATING a new Product
//--------------------------------------------------------------------------------------------	
	@RequestMapping(value = "/category/process", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("category") Category createCategory, BindingResult result) {
		if (result.hasErrors()) {
			return "/categoryProduct/createCategory.jsp";
		} else {
			categoryProductService.createCategory(createCategory);
			return "redirect:/categories/" + createCategory.getId();
		}
	}
//--------------------------------------------------------------------------------------------
// GET route for READING one Product by ID
//--------------------------------------------------------------------------------------------	
	@GetMapping("/categories/{category_id}")
	public String getPerson(@PathVariable("category_id") Long id, Model model, @ModelAttribute("categoryProduct") CategoryProduct categoryProduct) { 
		model.addAttribute("category", categoryProductService.findCategory(id));
		List<Product> products = categoryProductService.allProducts();
		model.addAttribute("products", products);
		return "/categoryProduct/readOneCategory.jsp";
	}
//--------------------------------------------------------------------------------------------
// POST route for adding a Category to a Product on the Categories page
//--------------------------------------------------------------------------------------------	
	@RequestMapping("/addCategoryToProduct")
	public String addCategory(@ModelAttribute("categoryProduct") CategoryProduct categoryProduct, Model model) {
		categoryProductService.addProductOrCategory(categoryProduct);
		return "redirect:/categories/" + categoryProduct.getCategory().getId();
	}
}

