package com.online.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.entities.Product;
import com.online.service.ProductServiceImpl;

@CrossOrigin
@RestController
@RequestMapping(value = "/online")
public class ProductController {

	@Autowired
	private ProductServiceImpl productService;

	@GetMapping("/home")
	public String home() {
		return "index";
	}
	
	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}


	/**
	 * @param Product
	 * @return
	 */
	@PostMapping("/addProduct")
	public @ResponseBody void addProductDetails(@RequestBody Product Product) {

		System.out.println("Add Product..." + Product);
		productService.addProduct(Product);

	}

	/**
	 * @return
	 */
	@GetMapping("/products")
	public @ResponseBody List<Product> retrieveDetails() {

		return productService.retrieveProductDetails();

	}

}
