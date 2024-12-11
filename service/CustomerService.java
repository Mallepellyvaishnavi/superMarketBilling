package com.hibernate.service;

import org.hibernate.SessionFactory;

public interface CustomerService {

	 void createCustomer(SessionFactory sf);
	    
	    void updateCustomer(SessionFactory sf);
	    
	    void deleteCustomer(SessionFactory sf);
	    
	   void getCustomerById(SessionFactory sf);
	    
	   void getAllCustomers(SessionFactory sf);
}


