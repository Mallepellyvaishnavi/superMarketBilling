package com.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor

public class Orders {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY for auto-increment

	private int id;
	private double totalAmount;
	
	
	  @ManyToOne // Defines a many-to-one relationship with Customer
	    @JoinColumn(name = "customer_id")
	    private Customer customer;
	  
	  
	  @ManyToOne // Defines a many-to-one relationship with Seller
	    @JoinColumn(name = "seller_id")
	    private Seller seller;


	@Override
	public String toString() {
		return "Orders [id=" + id + ", totalAmount=" + totalAmount + ", customer=" + customer + ", seller=" + seller
				+ "]";
	}


	

/*	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Seller getSeller() {
		return seller;
	}


	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	  
}*/

	  
}


