package com.hibernate.serviceimpl;

import java.util.List;
import java.util.Scanner;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.entity.Customer;
import com.hibernate.entity.Orders;
import com.hibernate.entity.Seller;
import com.hibernate.service.OrdersService;

public class OrderServiceImpl implements OrdersService {

	Scanner sc = new Scanner(System.in);
	
    @Override
    public void createOrder(SessionFactory sf) {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                Orders order = new Orders();

                System.out.println("Enter total amount:");
                double totalAmount = sc.nextDouble();
                order.setTotalAmount(totalAmount);

                // Assuming you have methods to retrieve Customer and Seller
                System.out.println("Enter customer ID:");
                int customerId = sc.nextInt();
                Customer customer = session.get(Customer.class, customerId);
                order.setCustomer(customer);

                System.out.println("Enter seller ID:");
                int sellerId = sc.nextInt();
                Seller seller = session.get(Seller.class, sellerId);
                if (seller != null) {
                    order.setSeller(seller);
                } else {
                    System.out.println("Seller not found.");
                    return; // Exit the method if the seller is not found
                }
                session.persist(order);
                transaction.commit();
                System.out.println("Order created with ID: " + order.getId());
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateOrder(SessionFactory sf) {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                System.out.println("Enter order ID to update:");
                int id = sc.nextInt();
                Orders order = session.get(Orders.class, id);
                if (order != null) {
                    System.out.println("Enter new total amount:");
                    order.setTotalAmount(sc.nextDouble());

                    System.out.println("Enter new customer ID (or -1 to skip):");
                    int customerId = sc.nextInt();
                    if (customerId != -1) {
                        Customer customer = session.get(Customer.class, customerId);
                        order.setCustomer(customer);
                    }

                    System.out.println("Enter new seller ID (or -1 to skip):");
                    int sellerId = sc.nextInt();
                    if (sellerId != -1) {
                        Seller seller = session.get(Seller.class, sellerId);
                        order.setSeller(seller);
                    }

                    session.update(order);
                    transaction.commit();
                    System.out.println("Order updated successfully.");
                } else {
                    System.out.println("Order not found!");
                }
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteOrder(SessionFactory sf) {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                System.out.println("Enter order ID to delete:");
                int id = sc.nextInt();
                Orders order = session.get(Orders.class, id);
                if (order != null) {
                    session.delete(order);
                    transaction.commit();
                    System.out.println("Order deleted successfully.");
                } else {
                    System.out.println("Order not found!");
                }
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public void getOrderById(SessionFactory sf) {
        try (Session session = sf.openSession()) {
            System.out.println("Enter order ID:");
            int id = sc.nextInt();
            Orders order = session.get(Orders.class, id);
            if (order != null) {
                System.out.println("Order Details: " + order);
            } else {
                System.out.println("Order not found!");
            }
        }
    }
	    @Override
	    public void getAllOrders(SessionFactory sf) {
	        try (Session session = sf.openSession()) {
	            TypedQuery<Orders> query = session.createQuery("FROM Orders", Orders.class);
	            List<Orders> resultList = query.getResultList();

	            for (Orders order : resultList) {
	                System.out.println(order); // Print each order
	            }
	        } catch (Exception e) {
	            e.printStackTrace(); // Handle exceptions appropriately
	        }
	    }


    // New methods for additional CRUD operations
    public List<Orders> getOrdersByCustomerId(SessionFactory sf) {
        try (Session session = sf.openSession()) {
            System.out.println("Enter customer ID to retrieve orders:");
            int customerId = sc.nextInt();
            Query query = session.createQuery("FROM Orders WHERE customer.id = :customerId");
            query.setParameter("customerId", customerId);
            return query.getResultList();
        }
    }

    public List<Orders> getOrdersBySellerId(SessionFactory sf) {
        try (Session session = sf.openSession()) {
            System.out.println("Enter seller ID to retrieve orders:");
            int sellerId = sc.nextInt();
            Query query = session.createQuery("FROM Orders WHERE seller.id = :sellerId");
            query.setParameter("sellerId", sellerId);
            return query.getResultList();
        }
    }
}





