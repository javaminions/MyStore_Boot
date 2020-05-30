package com.javaminions.pojos;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Product implements Serializable{

	@Id
	private String code;
	
    public Product(String code2, String name2, String description2, int inventory2, double price2, String category2,
			String img2) {
		
	}
    
    public Product () {
    	
    }
    
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	private String name; 
    private String description;
    private int inventory; 
    private double price;
    private String category; 
    private String img;
    
    public String getPriceCurrencyFormat() {
        return NumberFormat.getCurrencyInstance(Locale.US).format(price);
    }

	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", description=" + description + ", inventory=" + inventory
				+ ", price=" + price + ", category=" + category + ", img=" + img + "]";
	}
    

	

}
