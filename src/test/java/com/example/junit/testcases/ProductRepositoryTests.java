package com.example.junit.testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.profiles.entity.Product;
import com.example.profiles.repository.ProductRepository;

@DataJpaTest
public class ProductRepositoryTests {
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void saveProductTest() {
		Product product=new Product("Iphone",1000,"Mobile");
		Product eProduct=productRepository.save(product);
		assertEquals(eProduct, product);
		
	}
	
	@Test
	public void fetchAllProductsTest() {
		List<Product> products=new ArrayList<>();
		products.add(new Product("Iphone",1000,"Mobile"));
		products.add(new Product("Hp",2000,"Laptop"));
		products.add(new Product("H&M",3000,"Cloth"));
		List<Product> saveProducts=productRepository.saveAll(products);
		//List<Product> exProducts=productRepository.findAll();
		assertEquals(3, saveProducts.size());
	}
	
	@Test
	public void fetchProductById() {
		Product product=new Product("Iphone",1000,"Mobile");
		Product savedProduct=productRepository.save(product);
		Optional<Product> eProduct=productRepository.findById(savedProduct.getId());
		assertEquals(savedProduct.getId(), eProduct.get().getId());
	}

}
