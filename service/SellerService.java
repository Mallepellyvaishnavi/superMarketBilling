package com.hibernate.service;

import org.hibernate.SessionFactory;

public interface SellerService {
	void createSeller(SessionFactory sf);
    void updateSeller(SessionFactory sf);
    void deleteSeller(SessionFactory sf);
    void getSellerById(SessionFactory sf);
    void getAllSellers(SessionFactory sf);
   boolean authenticateSeller(SessionFactory sf, String username, String password);
}




