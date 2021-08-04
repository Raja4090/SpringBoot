package com.phoenix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phoenix.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
