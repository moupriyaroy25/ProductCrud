package com.example.Sample.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Sample.entity.Product;


public interface ProductService {

    //create product
	Product createProduct(Product p);
	
	
    //read product by id
    Product getProductById(int pid);
    
    //read all product
    List<Product> getAllProduct();
    
    //update a product
    Product updateProduct(Product p);
    
    //delete a product
    void deleteProduct(int pid);
    
    //find product by company
    
    List<Product> findByCompany(String company);
}
