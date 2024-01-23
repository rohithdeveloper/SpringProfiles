package com.example.junit.testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.profiles.controller.ProductController;
import com.example.profiles.entity.Product;
import com.example.profiles.serviceimpl.ProductServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTests {
	@InjectMocks
	private ProductController productController;

	@Mock
	private ProductServiceImpl productServiceImpl;
	
	@Test
	public void welcomeTest() {
		ProductController productController=new ProductController();
		String resultString=productController.welcome();
		assertEquals(resultString, "Welcome to springboot security");
	}
	
	@Test
	public void saveProducttest() {
		Product product=new Product("Iphone",1000,"Mobile");
		when(productServiceImpl.saveProduct(product)).thenReturn(product);
		Product expectedProduct=productController.saveProducts(product);
		assertEquals(product, expectedProduct);
		
	}
	
	@Test
	public void fetchProductsTest() {
		List<Product> products=new ArrayList<>();
		products.add(new Product("Iphone",1000,"Mobile"));
		products.add(new Product("Hp",2000,"Laptop"));
		products.add(new Product("H&M",3000,"Cloth"));
		when(productServiceImpl.fetchAllProducts()).thenReturn(products);
		List<Product> exProducts=productController.fetchProducts();
	}
	
	@Test
	public void fetchProductByIdTests() {
		Product p=new Product("Iphone",1000,"Mobile");
		when(productServiceImpl.fetchProduct(1)).thenReturn(p);
		Product eProduct=productController.fetchProductById(1);
	}

}
