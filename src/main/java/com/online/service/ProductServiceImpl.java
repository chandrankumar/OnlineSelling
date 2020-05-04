package com.online.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.dao.ProductDaoImpl;
import com.online.entities.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDaoImpl productDao;
	
	
	@Override
	@Transactional
	public void addProduct(Product product) {
		
		productDao.addProduct(product);
	}

	@Transactional
	public List<Product> retrieveProductDetails() {
		return productDao.retrieveProductDetails();
	}

	
}
