package com.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY for auto-increment

	private int id;
	 private String Productname;
	   private double price;
	   private int stockQuantity;
		/*
		 * public int getId() { return id; } public void setId(int id) { this.id = id; }
		 * public String getProductname() { return Productname; } public void
		 * setProductname(String productname) { Productname = productname; } public
		 * double getPrice() { return price; } public void setPrice(double price) {
		 * this.price = price; } public int getStockQuantity() { return stockQuantity; }
		 * public void setStockQuantity(int stockQuantity) { this.stockQuantity =
		 * stockQuantity; }
		 */
	@Override
	public String toString() {
		return "Product [id=" + id + ", Productname=" + Productname + ", price=" + price + ", stockQuantity="
				+ stockQuantity + "]";
	}	    
	   
}

	


