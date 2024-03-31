package com.example.Sample.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Sample.entity.Product;
import com.example.Sample.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor


public class ProductController {
	
	private ProductService ps;
	
	@PostMapping("createProduct")
	
	
	public ResponseEntity<Product> createProduct(@RequestBody Product p){
		Product savedProduct= ps.createProduct(p);
		return new ResponseEntity<>(savedProduct,HttpStatus.CREATED);
		
	}
	
	@GetMapping("{pid}")
	public ResponseEntity<Product> getProductById(@PathVariable("pid") int pid){
		Product product= ps.getProductById(pid);
		return new ResponseEntity<>(product,HttpStatus.OK);
		
	}
	
	@GetMapping("display")
	
	public ResponseEntity<List<Product>> getAllProduct(){
		List<Product> prodList= ps.getAllProduct();
		return new ResponseEntity<>(prodList,HttpStatus.OK);
	}
	
	@GetMapping("{company}")
	
	public ResponseEntity<List<Product>> getAllProductByCompany(@PathVariable("company") String company){
		List<Product> prodList= ps.findByCompany(company);
		return new ResponseEntity<>(prodList,HttpStatus.OK);
	}
	
	//update completed
	
	
	@PutMapping("{id}")
	
	public ResponseEntity<Product> updateProduct(@PathVariable("id") int pid,@RequestBody Product p){
		p.setPid(pid);
		
		Product updatedProduct=ps.updateProduct(p);
		
		
		return new ResponseEntity<>(updatedProduct,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("{lid}")
	
	public ResponseEntity<String> deleteProduct(@PathVariable("id") int pid){
		ps.deleteProduct(pid);
		return new ResponseEntity<>("Product deleted Successfully!",HttpStatus.OK);
		
	}
	
	
	
	
	
	
	

}
