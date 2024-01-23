package com.example.junit.testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.profiles.entity.Product;
import com.example.profiles.repository.ProductRepository;
import com.example.profiles.serviceimpl.ProductServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTests {

	@Mock
	private ProductRepository productRepo;
	
	@InjectMocks
	private ProductServiceImpl productService;
	
	@Test
	public void saveProductTest() {
		Product p=new Product("Iphone",1000,"Mobile");
		when(productRepo.save(p)).thenReturn(p);//Moking statement
		Product p1=	productService.saveProduct(p);
		assertEquals(p1,p);
	}
	
	@Test
	public void fetchALlProductsTest() {
		List<Product> products=new ArrayList<>();
		products.add(new Product("Iphone",1000,"Mobile"));
		products.add(new Product("Hp",2000,"Laptop"));
		products.add(new Product("H&M",3000,"Cloth"));
		when(productRepo.findAll()).thenReturn(products);
		List<Product> list=productService.fetchAllProducts();
		assertEquals(3, products.size());
		
	}
	
	@Test
	public void fetchProductByIdTest() {
		Product p=new Product("Iphone",1000,"Mobile");
		when(productRepo.findById(1)).thenReturn(Optional.of(p));//Moking statement
		Product p1=	productService.fetchProduct(1);
		assertEquals(p1,p);
		
	}
}
