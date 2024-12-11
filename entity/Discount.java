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
public class Discount {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY for auto-increment
	    private int id;
	    private int minQuantity;
	    private double discountAmount;
	    private String description;
		/*
		 * public int getId() { return id; } public void setId(int id) { this.id = id; }
		 * public int getMinQuantity() { return minQuantity; } public void
		 * setMinQuantity(int minQuantity) { this.minQuantity = minQuantity; } public
		 * double getDiscountAmount() { return discountAmount; } public void
		 * setDiscountAmount(double discountAmount) { this.discountAmount =
		 * discountAmount; } public String getDescription() { return description; }
		 * public void setDescription(String description) { this.description =
		 * description; }
		 */
		@Override
		public String toString() {
			return "Discount [id=" + id + ", minQuantity=" + minQuantity + ", discountAmount=" + discountAmount
					+ ", description=" + description + "]";
		}
	    
	    
	}


