
package com.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Seller {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate the seller ID
     private Integer id;
  private String sellername;
  private String password;
  
  
  @OneToOne(targetEntity = Admin.class, cascade = CascadeType.ALL)// Specify the target entity
  @JoinColumn(name = "admin_id") // This column will reference the Admin table
  private Admin admin; // Reference to the Admin


	/*
	 * public Integer getId() { return id; } public void setId(Integer id) { this.id
	 * = id; } public String getSellername() { return sellername; } public void
	 * setSellername(String sellername) { this.sellername = sellername; } public
	 * String getPassword() { return password; } public void setPassword(String
	 * password) { this.password = password; } public Admin getAdmin() { return
	 * admin; }
	 * 
	 * public void setAdmin(Admin admin) { this.admin = admin; }
	 */
	@Override
	public String toString() {
		return "Seller [id=" + id + ", sellername=" + sellername + ", password=" + password + ", admin=" + admin + "]";
	}
  

}

	

