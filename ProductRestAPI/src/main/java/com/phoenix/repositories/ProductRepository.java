package com.phoenix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.phoenix.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	
	
	List<Product> findByName(String name);
	List<Product> getProductByNameAndPrice(String name,float price);
	
	@Query("select p from Product p where p.name=?1 order by p.price")
	List<Product> findByNameAndSortByPrice(String name);
	
	@Query("select p from Product p where p.price between ?1 and ?2")
	List<Product> findByMinPriceAndMaxPrice(float minPrice,float maxPrice);
	
	@Query("select p from Product p order by p.name")
	List<Product> sortByName();
	
	@Query("select p from Product p where p.name=?1 and p.price=?2")
	List<Product> findByNameAndPrice(String name,float price);
	
	
}
