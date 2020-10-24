package com.productservice.sales.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.productservice.model.Product;

@Entity
@Table(name = "user_cart")
public class UserCart {

	@Id
	private Integer cart_id;

	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "uc_fk", referencedColumnName = "cart_id")
	private List<Product> product;

	@Column(name = "quantity")
	private double quantity;

	@Column(name = "total_price")
	private double total_price;

	@Column(name = "discount_price")
	private double discount_price;

	public UserCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserCart(Integer cart_id, List<Product> product_id, double quantity, double total_price,
			double discount_price) {
		super();
		this.cart_id = cart_id;
		this.product = product_id;
		this.quantity = quantity;
		this.total_price = total_price;
		this.discount_price = discount_price;
	}

	public double getDiscount_price() {
		return discount_price;
	}

	public void setDiscount_price(double discount_price) {
		this.discount_price = discount_price;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public Integer getCart_id() {
		return cart_id;
	}

	public void setCart_id(Integer cart_id) {
		this.cart_id = cart_id;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product_id) {
		this.product = product_id;
	}

}
