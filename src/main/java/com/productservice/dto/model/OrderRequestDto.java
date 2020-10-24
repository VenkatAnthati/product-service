package com.productservice.dto.model;

import java.util.List;

import com.productservice.model.Product;

public class OrderRequestDto {
	
	List prodctid;

	public List getProdctid() {
		return prodctid;
	}

	public void setProdctid(List prodctid) {
		this.prodctid = prodctid;
	}
	
	//List<Product> product;

}
