package com.example.profiles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.profiles.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	
}
