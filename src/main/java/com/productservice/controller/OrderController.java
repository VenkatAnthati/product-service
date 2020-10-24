package com.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productservice.dao.ProductDao;
import com.productservice.dto.model.OrderRequestDto;
import com.productservice.sales.model.orderSummary;
import com.productservice.service.ProductSevice;

@RestController
public class OrderController {
	
	@Autowired
	ProductDao proddao;
	@Autowired
	ProductSevice productService;
	
	
	@GetMapping("/shop/placeOrder")
	public orderSummary placeOrder(@RequestBody OrderRequestDto orderrequest) {
        
		List listOfProductId = orderrequest.getProdctid();
		
		if(listOfProductId.isEmpty()) {
			
			return null;
		}
             productService.getListOfProduct(listOfProductId);
		
		return null;
		
	}

}
