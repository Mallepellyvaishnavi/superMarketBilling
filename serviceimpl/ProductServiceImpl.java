package com.hibernate.serviceimpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.entity.Product;
import com.hibernate.service.ProductService;

public class ProductServiceImpl implements ProductService {
	Scanner sc=new Scanner(System.in);
	
	public 	void createProduct(SessionFactory sf) {
	    Session session = sf.openSession();
	    Transaction transaction = session.beginTransaction();
	    try {
	        Product product = new Product();

	        // Input for product details (you can use a Scanner or method parameters)
	        System.out.println("Enter product name:");
	        String productName = sc.next(); // Make sure to initialize 'sc' Scanner
	        product.setProductname(productName);

	        System.out.println("Enter price:");
	        double price = sc.nextDouble();
	        product.setPrice(price);

	        System.out.println("Enter stock quantity:"); 
	        int stockQuantity = sc.nextInt();
	        product.setStockQuantity(stockQuantity);
	        session.persist(product); // ID will be auto-generated
	        transaction.commit();

	        System.out.println("Product created with ID: " + product.getId());
	    } catch (Exception e) {
	        transaction.rollback();
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	}

		


	 public    void updateProduct(SessionFactory sf) {
		 Session session = sf.openSession();
	     Transaction transaction = session.beginTransaction();
	    

	     try {
	         System.out.println("Enter product ID to update:");
	         int id = sc.nextInt();
	         Product product = session.get(Product.class, id);
	         if (product != null) {
	             System.out.println("Enter new product name:");
	             product.setProductname(sc.next());

	             System.out.println("Enter new price:");
	             product.setPrice(sc.nextDouble());

	             System.out.println("Enter new stock quantity:");
	             product.setStockQuantity(sc.nextInt());

	             session.update(product);
	             transaction.commit();
	             System.out.println("Product updated successfully.");
	         } else {
	             System.out.println("Product not found!");
	         }
	     } catch (Exception e) {
	         transaction.rollback();
	         e.printStackTrace();
	     } finally {
	         session.close();
	     }
	 }

	 @Override
	 public void deleteProduct(SessionFactory sf) {
	     Session session = sf.openSession();
	     Transaction transaction = session.beginTransaction();

	     try {
	         System.out.println("Enter product ID to delete:");
	         int id = sc.nextInt();
	         Product product = session.get(Product.class, id);
	         if (product != null) {
	             session.delete(product);
	             transaction.commit();
	             System.out.println("Product deleted successfully.");
	         } else {
	             System.out.println("Product not found!");
	         }
	     } catch (Exception e) {
	         transaction.rollback();
	         e.printStackTrace();
	     } finally {
	         session.close();
	     }
	 }

	 @Override
	 public void getProductById(SessionFactory sf) {
	     Session session = sf.openSession();

	     try {
	         System.out.println("Enter product ID:");
	         int id = sc.nextInt();
	         Product product = session.get(Product.class, id);
	         if (product != null) {
	             System.out.println("Product Details: " + product);
	         } else {
	             System.out.println("Product not found!");
	         }
	     } finally {
	         session.close();
	     }
	 }

	 @Override
	 public void getAllProducts(SessionFactory sf) {
	     Session session = sf.openSession();
	 
	     try {
	         Query query = session.createQuery("FROM Product");
	         List<Product> products = query.getResultList();
	         for (Product product : products) {
	             System.out.println(product);
	         }
	     } finally {
	         session.close();
	     }
	 }
	}


	 
		
		





