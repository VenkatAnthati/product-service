package com.productservice.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long product_id;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "list_price")
	private double price;

	@Column(name = "brand_id")
	private Integer brand;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id", nullable =true)
	private Category category;

	@Column(name = "model_year")
	private Date modelYear;


	/**
	 * Default constructor.
	 */
	public Product() {
	}

	public Product(Long product_id, String productName, double price, Integer brand, Category category,
			Date modelYear) {
		super();
		this.product_id = product_id;
		this.productName = productName;
		this.price = price;
		this.brand = brand;
		this.category = category;
		this.modelYear = modelYear;
	}

	/**
	 * @return productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public Integer getBrand() {
		return brand;
	}

	public void setBrand(Integer brand) {
		this.brand = brand;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getModelYear() {
		return modelYear;
	}

	public void setModelYear(Date modelYear) {
		this.modelYear = modelYear;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", productName=" + productName + ", price=" + price + ", brand="
				+ brand + ", category=" + category + ", model_year=" + modelYear + "]";
	}

}
