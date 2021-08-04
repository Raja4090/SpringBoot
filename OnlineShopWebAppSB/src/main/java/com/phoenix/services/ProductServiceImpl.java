package com.phoenix.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoenix.entities.Product;
import com.phoenix.entities.User;
import com.phoenix.exceptions.ProductNotFoundException;
import com.phoenix.exceptions.UserNotFoundException;
import com.phoenix.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepo;


	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public void add(Product product) {
		// TODO Auto-generated method stub
		productRepo.save(product);
		
	}

	@Override
	public void edit(Product product) {
		// TODO Auto-generated method stub
		productRepo.save(product);
		
	}

	@Override
	public void remove(Product product) {
		// TODO Auto-generated method stub
		productRepo.delete(product);
		
	}

	
}
