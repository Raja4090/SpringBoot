package com.phoenix.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.phoenix.entities.Product;
import com.phoenix.services.ProductService;


@Controller
public class ProductController {

	@Autowired
	 private ProductService productService;

	
	@GetMapping("/product")
	public  String productValidate(Product product,HttpSession session) {
		  
				//Presentation Layer
			List<Product> products =  productService.findAllProducts();
			if (session != null) {	
					session.setAttribute("products", products);
					return "products.jsp";
				} else {
					return "Time:out pleas visit in give time frame";
				}
		
	  }
}