package com.javaminions.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Supplierorders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int productcode;
	private int quantity;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductcode() {
		return productcode;
	}
	public void setProductcode(int productcode) {
		this.productcode = productcode;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Supplierorders [id=" + id + ", productcode=" + productcode + ", quantity=" + quantity + ", status="
				+ status + "]";
	}
	public Supplierorders(int id, int productcode, int quantity, String status) {
		super();
		this.id = id;
		this.productcode = productcode;
		this.quantity = quantity;
		this.status = status;
	}
	public Supplierorders() {
		super();
	}
}