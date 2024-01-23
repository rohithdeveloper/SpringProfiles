package com.example.profiles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.profiles.entity.Product;
import com.example.profiles.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to springboot security";
	}
	@PostMapping("/send")
	public Product saveProducts(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	
	@GetMapping("/product/fetchAll")
	public List<Product> fetchProducts(){
		List<Product> list=productService.fetchAllProducts();
		return list;
	}
	
	@GetMapping("/product/fetch/{id}")
	public Product fetchProductById(@PathVariable int id){
		return productService.fetchProduct(id);
	}
	
}
