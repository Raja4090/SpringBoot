package com.phoenix.services;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.phoenix.entities.Product;
import com.phoenix.exceptions.ProductNotFoundException;

public interface ProductService {
	
    List<Product> findAllProducts();
    void add(Product product);
    void edit(Product product);
    void remove(Product product);
}
