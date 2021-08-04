package com.phoenix.data;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.phoenix.data.entities.Product;
import com.phoenix.data.repositories.ProductRepository;

@SpringBootApplication
public class SpringJpaDemoApplication implements CommandLineRunner{
	
	private static final Logger LOG=LogManager.getLogger();
	
	@Autowired
	private ProductRepository productRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		LOG.info("======================================");
		LOG.info("======================================");
		LOG.info("Product Count: "+productRepo.count());
		
	    Iterable<Product> products=productRepo.findAll();
	    LOG.info("======================================");
		LOG.info("===================Displaying all products===================");
		products.forEach(System.out::println);
		
		//crud operation
		LOG.info("======================================");
		LOG.info("===================Find By Name===================");
		
		List<Product> pByNm=productRepo.findByName("Home Theatre");
		pByNm.forEach(Product-> LOG.info(Product));
		
		LOG.info("======================================");
		LOG.info("===================Find By Name And Price===================");
        pByNm=productRepo.getProductByNameAndPrice("Basket ball", 0.0f);
        pByNm.forEach(Product-> LOG.info(Product));
		
        
        
        LOG.info("======================================");
		LOG.info("===================Find By Name and sort by price===================");
        pByNm=productRepo.findByNameAndSortByPrice("Basket ball");
        pByNm.forEach(Product-> LOG.info(Product));
        
        
        LOG.info("======================================");
		LOG.info("===================Filtering result between max and min price===================");
        pByNm=productRepo.findByMinPriceAndMaxPrice(4000.0f,50000.0f);
        pByNm.forEach(Product-> LOG.info(Product));
        
        
        LOG.info("======================================");
		LOG.info("===================sorting by name===================");
        pByNm=productRepo.sortByName();
        pByNm.forEach(Product-> LOG.info(Product));
        
        LOG.info("======================================");
		LOG.info("===================Deleting by id===================");
		
		Optional<Product> product=productRepo.findById(1);
		if(product.isPresent())
		{
		    	Product p=product.get();
		    	productRepo.delete(p);
		    	LOG.info("Product id: "+p.getId()+" deleted successfully.....!");
		}
		else
			LOG.info("Product not found.....!");
		
		LOG.info("======================================");
		LOG.info("===================Updating Product===================");
		product=productRepo.findById(2);
		if(product.isPresent())
		{
			Product p=product.get();
			float oldPrice=p.getPrice();
		    p.setPrice(oldPrice+100);
		    productRepo.save(p);
		    float newPrice=p.getPrice();
		    LOG.info("Old Price: "+oldPrice+" repleced with New Price: "+newPrice);
		}
		else
			LOG.info("Sorry! Product doesn't exist.....!");
		
		/*
		LOG.info("======================================");
		LOG.info("===================Inserting Product===================");
		
		 Product p1=new Product(100,"Power bank",450.0f);
		 productRepo.save(p1);
		 LOG.info("Product inserted successfully......!");
		 */
		
		
	}
	
	

	
}
