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
public class Customer {

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY for auto-increment

		    private Integer id;
		    private  String customerName;
		    private Long phoneno;
		    private String email;
		    /*public Customer() {}
			public Integer getId() {
				return id;
			}
			public void setId(Integer id) {
				this.id = id;
			}
			public String getUstomerName() {
				return ustomerName;
			}
			public void setUstomerName(String ustomerName) {
				this.ustomerName = ustomerName;
			}
			public Long getPhoneno() {
				return phoneno;
			}
			public void setPhoneno(Long phoneno) {
				this.phoneno = phoneno;
			}
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
		    
}
*/
			@Override
			public String toString() {
				return "Customer [id=" + id + ", ustomerName=" + customerName + ", phoneno=" + phoneno + ", email="
						+ email + "]";
			}
		    
}


