package com.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.productservice.model.Product;

@Service
public interface ProductSevice {

	
	Product getProductByIdAndName(Long id, String name);

	void save(Product product);

	void getListOfProduct(List listOfProductId);
	
	public void generateExcel();

	void generatePdf();
}
