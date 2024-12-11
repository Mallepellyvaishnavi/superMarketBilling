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

@Setter
@Getter
@NoArgsConstructor

@Entity
public class OrderItems {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY for auto-increment

	private  Integer itemid;
	private Integer quantity;
	  @ManyToOne // Defines a many-to-one relationship with Orders
	    @JoinColumn(name = "orders_id") // Foreign key column in OrderItem table
	    private Orders orders;

	    @ManyToOne // Defines a many-to-one relationship with Product
	    @JoinColumn(name = "product_id") // Foreign key column in OrderItem table
	    private Product product;
	    // Constructors
		/*
		 * public OrderItems() {} public Integer getItemid() { return itemid; } public
		 * void setItemid(Integer itemid) { this.itemid = itemid; } public Integer
		 * getQuantity() { return quantity; } public void setQuantity(Integer quantity)
		 * { this.quantity = quantity; } public Orders getOrders() { return orders; }
		 * public void setOrders(Orders orders) { this.orders = orders; } public Product
		 * getProduct() { return product; } public void setProduct(Product product) {
		 * this.product = product; }
		 * 
		 * 
		 */

		@Override
		public String toString() {
			return "OrderItems [itemid=" + itemid + ", quantity=" + quantity + ", orders=" + orders + ", product="
					+ product + "]";
		}
	    

}


