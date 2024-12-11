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
public class Admin {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY for auto-increment

       private Integer id;
       private String username;
       private String password;
       private String email;
     
   	
		/*
		 * public Admin() {
		 * 
		 * }
		 */

	/*
	 * public Integer getId() { return id; } public void setId(Integer id) { this.id
	 * = id; } public String getUsername() { return username; } public void
	 * setUsername(String username) { this.username = username; } public String
	 * getPassword() { return password; } public void setPassword(String password) {
	 * this.password = password; } public String getEmail() { return email; } public
	 * void setEmail(String email) { this.email = email; }
	 */
	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + "]";
	}
       
	
	
}


