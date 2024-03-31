package com.example.Sample.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Sample.entity.Product;
import com.example.Sample.repo.ProductRepository;
import com.example.Sample.service.ProductService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class ProductServiceImpl implements ProductService{
	
	
	//creating the reference variable to store address of new product object
	//Up casting
	ProductRepository pr;



	@Override
	public Product createProduct(Product p) {
		
		return pr.save(p);
	}
	
	//read product by id

	@Override
	public Product getProductById(int pid) {
		
		Optional<Product> optionalProduct= pr.findById(pid);
		
		return optionalProduct.get();
	}
	
	//read all product

	@Override
	public List<Product> getAllProduct() {
		
		return pr.findAll();
	}

	@Override
	public Product updateProduct(Product p) {
		Product existingProduct = pr.findById(p.getPid()).get();
		existingProduct.setCompany(p.getCompany());
		existingProduct.setName(p.getName());
		existingProduct.setPrice(p.getPrice());
		
		Product updateProduct = pr.save(existingProduct);
		
		
		return updateProduct;
	}
	
	//delete the product

	@Override
	public void deleteProduct(int pid) {
		
		pr.deleteById(pid);
		
	}

	@Override
	public List<Product> findByCompany(String company) {
		
		return pr.findByCompany(company);
	}

}
