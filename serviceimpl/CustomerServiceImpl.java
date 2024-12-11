package com.hibernate.serviceimpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.entity.Customer;
import com.hibernate.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{
	

	 private Scanner sc = new Scanner(System.in);

	    public void createCustomer(SessionFactory sf) {
	        try (Session session = sf.openSession()) {
	            Transaction transaction = session.beginTransaction();
	            try {
	                Customer customer = new Customer();

	                System.out.println("Enter values for customer: name, phone number, and email:");
	                customer.setCustomerName(sc.next());
	                customer.setPhoneno(sc.nextLong());
	                customer.setEmail(sc.next());

	                session.persist(customer); // ID will be auto-generated
	                transaction.commit();

	                System.out.println("Customer created with ID: " + customer.getId());
	            } catch (Exception e) {
	                transaction.rollback();
	                e.printStackTrace();
	            }
	        }
	    }

	    public void updateCustomer(SessionFactory sf) {
	        try (Session session = sf.openSession()) {
	            Transaction transaction = session.beginTransaction();
	            try {
	                while (true) {
	                    System.out.println("Choose option for update \n1.Update Customer Name\n2.Update Phone Number\n3.Update Email\n4.Exit");
	                    int option = sc.nextInt();

	                    if (option == 4) {
	                        System.out.println("Exiting from update customer.");
	                        break;
	                    }

	                    System.out.println("Enter customer id:");
	                    int customerId = sc.nextInt();
	                    Customer customer = session.get(Customer.class, customerId);
	                    if (customer == null) {
	                        System.out.println("Customer not found!");
	                        continue;
	                    }

	                    switch (option) {
	                        case 1:
	                            System.out.println("Enter new customer name:");
	                            customer.setCustomerName(sc.next());
	                            break;
	                        case 2:
	                            System.out.println("Enter new phone number:");
	                            customer.setPhoneno(sc.nextLong());
	                            break;
	                        case 3:
	                            System.out.println("Enter new email:");
	                            customer.setEmail(sc.next());
	                            break;
	                        default:
	                            System.out.println("Choose the correct option.");
	                            continue;
	                    }

	                    session.update(customer); // Update the customer in the session
	                    transaction.commit(); // Commit each update individually
	                    transaction = session.beginTransaction(); // Restart transaction for the next iteration
	                }
	            } catch (Exception e) {
	                transaction.rollback();
	                e.printStackTrace();
	            }
	        }
	    }

	    public void deleteCustomer(SessionFactory sf) {
	        try (Session session = sf.openSession()) {
	            Transaction transaction = session.beginTransaction();
	            try {
	                System.out.println("Enter customer id:");
	                int id = sc.nextInt();

	                Customer customer = session.get(Customer.class, id);
	                if (customer != null) {
	                    session.delete(customer);
	                    transaction.commit();
	                    System.out.println("Customer deleted successfully.");
	                } else {
	                    System.out.println("Enter a valid customer id.");
	                }
	            } catch (Exception e) {
	                transaction.rollback();
	                e.printStackTrace();
	            }
	        }
	    }

	    public void getCustomerById(SessionFactory sf) {
	        try (Session session = sf.openSession()) {
	            System.out.println("Enter customer id:");
	            int id = sc.nextInt();

	            Customer customer = session.get(Customer.class, id);
	            if (customer != null) {
	                System.out.println(customer);
	            } else {
	                System.out.println("Customer not found!");
	            }
	        }
	    }

	    public void getAllCustomers(SessionFactory sf) {
	        try (Session session = sf.openSession()) {
	            Query<Customer> query = session.createQuery("from Customer", Customer.class);
	            List<Customer> resultList = query.getResultList();

	            for (Customer c : resultList) {
	                System.out.println(c);
	            }
	        }
	    }
	}