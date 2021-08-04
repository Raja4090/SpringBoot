package com.phoenix.controllers.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phoenix.entities.Product;
import com.phoenix.repositories.ProductRepository;

@RequestMapping("/product")
@RestController
public class ProductRestController {

	@Autowired
	private ProductRepository productRepo;
	
	@GetMapping
	public List<Product> getAllProducts()
	{
		
		return productRepo.findAll();
	}
	
	@GetMapping("/{pid}")
	public Product getById(@PathVariable("pid") int id)
	{
		return productRepo.findById(id).get();
	}
	
	//insert new product
	@PutMapping
	public String addProduct(@RequestBody Product product)
	{
		product=productRepo.save(product);
		return "new Product "+product.getId()+" is added successfully!";
	}
	
	@PostMapping
	public String updateProduct(@RequestBody Product product)
	{
	    Optional<Product> op=productRepo.findById(product.getId());
	    if(op.isPresent())
	    {
	    	product=productRepo.save(product);
	    	return "Product : "+product.getName()+" updated successfully!";
	    }
	    else
	    	return " Product not found!";
	}
	
	@DeleteMapping
	public String deleteProduct(@RequestBody Product product)
	{
		Optional<Product> op=productRepo.findById(product.getId());
	    if(op.isPresent())
	    {
	    	productRepo.delete(product);
	    	return "Product : "+product.getName()+" deleted successfully!";
	    }
	    else
	    	return " Product not found!";
	}
	
	@PostMapping("/add-form")
	public String addFormData(@RequestParam("nm") String name,@RequestParam("price") float price) {
		Product p = new Product();
		p.setName(name);
		p.setPrice(price);
		
		p = productRepo.save(p);
		
		return "Form data with product " + p.getId() + " is added sucessfully!";
	}
	
	
	@GetMapping("/{nm}/{pr}")
	public List<Product> getProductBynameAndPrice(@PathVariable("nm") String name, @PathVariable("pr") float price ){
		return productRepo.findByNameAndPrice(name, price);
		
	}

	@GetMapping("/product-name/{nm}")
	public List<Product> getProductByname(@PathVariable("nm") String name){
		return productRepo.findByName(name);
	}
	
	@GetMapping("/success")
	public ResponseEntity<String> getSuccessMessage()
	{
		return ResponseEntity.ok("Congratulation! saved successfully..");
	}
}
