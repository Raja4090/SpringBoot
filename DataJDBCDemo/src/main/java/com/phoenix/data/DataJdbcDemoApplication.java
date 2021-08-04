package com.phoenix.data;

import java.util.List;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.phoenix.data.entities.Product1;
import com.phoenix.data.repositories.ProductRepository;

/*
 * author:raja.kumar@stltech.in
 * creaion data:30-07-2021
 * copyright=STL
 */
@SpringBootApplication
public class DataJdbcDemoApplication implements CommandLineRunner {

	private static final Logger LOG=LogManager.getLogger();
	
    @Autowired
	private ProductRepository productRepo;
	public static void main(String[] args) {
		SpringApplication.run(DataJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Iterable<Product1> products=productRepo.findAll();
		//products.forEach(System.out::println);
		products.forEach(product1->LOG.info(product1));
		LOG.info("========================================");
		LOG.info("========================================");
		/*Optional<Product1> product=productRepo.findById(100);
		if(product.isPresent())
		{
			Product1 p=product.get();
			LOG.debug("product: "+p);
			
		}
		else
		{
			LOG.error("Sorry! product not found....");
		}
		
		LOG.info("========================================");
		LOG.info("========================================");
		
		
		LOG.info("No.of product: "+productRepo.count());
		
		product=productRepo.findById(3006);
		if(product.isPresent())
		{
			Product1 p=product.get();
			float old=p.getPrice();
			p.setPrice(1000.0f+old);
			productRepo.save(p);
			float newPrice=p.getPrice();
			LOG.debug("product: "+p.getId()+" updated successfully!");
			
			LOG.info("Old price: "+old+" new price: "+newPrice);
		}
		else
			LOG.info("Sorry! not found....");
		
		LOG.info("========================================");
		LOG.info("========================================");
		
		product=productRepo.findById(3006);
		if(product.isPresent())
		{
			Product1 p=product.get();
			productRepo.delete(p);
			LOG.debug("product: "+p.getId()+" deleted successfully!");
			
		}
		else
			LOG.info("Sorry! not found....");
		
		LOG.info("========================================");
		LOG.info("========================================");
		
		Product1 product1=new Product1();
		product1.setId(3007);
		product1.setName("Home Theatre");
		product1.setPrice(78000.0f);
		product1.setInsert(true);
		productRepo.save(product1);
		
		LOG.info("new Product: "+product1.getId()+" added successfully");
		*/
		
		LOG.info("========================================");
		LOG.info("========================================");
		List<Product1> pByNm=productRepo.findByName("Laptop");
		pByNm.forEach(product1->LOG.info(product1));
		
		LOG.info("========================================");
		LOG.info("========================================");
		pByNm=productRepo.findByName("Home Theatre");
		pByNm.forEach(product1->LOG.info(product1));
		LOG.info("========================================");
		LOG.info("========================================");
		pByNm=productRepo.findByPrice(10500.0f);
		pByNm.forEach(product1->LOG.info(product1));
		
		LOG.info("========================================");
		LOG.info("========================================");
		pByNm=productRepo. findByPriceBetween(10000.0f,20000.0f);
		pByNm.forEach(product1->LOG.info(product1));
		
		LOG.info("========================================");
		LOG.info("========================================");
		pByNm=productRepo. findByNameAndPrice("Laptop",3600.0f);
		pByNm.forEach(product1->LOG.info(product1));
		
		LOG.info("========================================");
		LOG.info("========================================");
		pByNm=productRepo. findByNameLike("L%");
		pByNm.forEach(product1->LOG.info(product1));
		
		LOG.info("========================================");
		LOG.info("========================================");
		
		pByNm=productRepo. findByNameOrderByPrice("Laptop");
		pByNm.forEach(product1->LOG.info(product1));
		
		LOG.info("========================================");
		LOG.info("========================================");
		
		pByNm=productRepo.sortByName();
		pByNm.forEach(product1->LOG.info(product1));
		
		LOG.info("========================================");
		LOG.info("========================================");
		
		pByNm=productRepo.sortByName();
		pByNm.forEach(product1->LOG.info(product1));
		
		LOG.info("========================================");
		LOG.info("========================================");
		int updatePrice=productRepo.updatePriceByName("Laptop", 59000.0f);
		LOG.info("Price updated count : "+updatePrice);
		
		
		
		
		
		
	}

}
