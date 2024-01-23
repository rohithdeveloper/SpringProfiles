package com.example.profiles.service;

import java.util.List;

import com.example.profiles.entity.Product;

public interface ProductService {
	 Product saveProduct(Product product);
	 List<Product> fetchAllProducts();
	 Product fetchProduct(int id);
}
