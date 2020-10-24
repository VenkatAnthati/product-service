package com.productservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Category {

	
	@Id
	private Integer category_id;
	
	
	@Column(name = "category_name")
	private String category_name;


	public Integer getCategory_id() {
		return category_id;
	}


	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}


	public String getCategory_name() {
		return category_name;
	}


	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}


	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ", category_name=" + category_name + "]";
	}
	
	
	
}
