package com.hibernate.service;

import org.hibernate.SessionFactory;

public interface ProductService {

	void createProduct(SessionFactory sf);
    void updateProduct(SessionFactory sf);
    void deleteProduct(SessionFactory sf);
    void getProductById(SessionFactory sf);
    void getAllProducts(SessionFactory sf); 
    
    
    
    
}


