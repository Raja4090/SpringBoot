package com.phoenix.data.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.phoenix.data.entities.Product1;

//Dao interface
public interface ProductRepository extends CrudRepository<Product1,Integer> {

	//custom finder method
	List<Product1> findByName(String name);
	List<Product1> findByPrice(float price);
	List<Product1> findByPriceBetween(float minPrice,float maxPrice);
	List<Product1> findByNameAndPrice(String name,float price);
	List<Product1> findByNameLike(String name);
	
	List<Product1> findByNameOrderByPrice(String name);
	@Query("select * from product1 order by name")
	List<Product1> sortByName();
	
	@Query("select * from product1 where name=:nm and price=:pr")
	List<Product1> getProductByNameAndPrice(@Param("nm")String name,@Param("pr") float price);

	@Modifying
	@Query("update product1 set price=:pr where name=:nm")
	int updatePriceByName(@Param("nm") String name,@Param("pr") float price);
	
	
	@Modifying
	@Query("update product1 set price=:pr where name=:nm")
	boolean deleteProductByName(@Param("nm") String name);
	
	
	

}
