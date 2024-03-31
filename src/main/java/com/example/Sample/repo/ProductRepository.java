package com.example.Sample.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Sample.entity.Product;

//has access to database

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findByCompany(String company);

}
