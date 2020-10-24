package com.productservice.sales.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_summary")
public class orderSummary {
	
	@Id
	private Integer order_id;
	
	//private Integer customer_id;
	@Column(name = "order_status")
	private String order_status;
	
	@Column(name = "order_date")
	private Date order_date;
	
	@Column(name = "required_date")
	private Date required_date;
	
	@Column(name = "shipping_date")
	private Date shipping_date;

	
	
	
	public orderSummary() {
		// TODO Auto-generated constructor stub
	}

	public orderSummary(Integer order_id, String order_status, Date order_date, Date required_date, Date shipping_date) {
		super();
		this.order_id = order_id;
		this.order_status = order_status;
		this.order_date = order_date;
		this.required_date = required_date;
		this.shipping_date = shipping_date;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public Date getRequired_date() {
		return required_date;
	}

	public void setRequired_date(Date required_date) {
		this.required_date = required_date;
	}

	public Date getShipping_date() {
		return shipping_date;
	}

	public void setShipping_date(Date shipping_date) {
		this.shipping_date = shipping_date;
	}

	
	//private Integer store_id;
	
	//private Integer staff_if;
	

}
