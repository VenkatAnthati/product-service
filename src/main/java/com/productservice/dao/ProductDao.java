package com.productservice.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.productservice.model.Product;

@Service
public interface ProductDao {

	List<Product> findAll();
	
	Product findProductById(Long id);

	Product getProductByIdAndName(Long id, String name);

	void save(Product product);

	void getListOfProduct(List listOfProductId);
}
