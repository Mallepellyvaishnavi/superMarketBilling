package com.hibernate.service;

import org.hibernate.SessionFactory;

public interface AdminService {

	  void createAdmin(SessionFactory sf);
	    
	    void updateAdmin(SessionFactory sf);
	    
	    void deleteAdmin(SessionFactory sf);
	    
	   void getAdminById(SessionFactory sf);
	    
	   void getAllAdmins(SessionFactory sf);
	   boolean authenticateAdmin(SessionFactory sf, String username, String password);
	  }
	    
	    /*void authenticateAdmin(SessionFactory sf);
	}*/



