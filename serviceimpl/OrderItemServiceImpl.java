package com.hibernate.serviceimpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.entity.OrderItems;
import com.hibernate.entity.Orders;
import com.hibernate.entity.Product;
import com.hibernate.service.OrdersItemsService;

public class OrderItemServiceImpl implements OrdersItemsService{

	 Scanner sc = new Scanner(System.in);

		    @Override
		    public void createOrderItem(SessionFactory sf) {
		        Session session = sf.openSession();
		        Transaction transaction = session.beginTransaction();

		        try {
		            OrderItems orderItems = new OrderItems();
		            System.out.println("Enter quantity for the order item:");
		            int quantity = sc.nextInt();
		            orderItems.setQuantity(quantity); // Set quantity

		            System.out.println("Enter order ID:");
		            int orderId = sc.nextInt();
		            Orders order = session.get(Orders.class, orderId);
		            if (order != null) {
		                orderItems.setOrders(order); // Set associated order
		            } else {
		                System.out.println("Order not found!");
		                return;
		            }

		            System.out.println("Enter product ID:");
		            int productId = sc.nextInt();
		            Product product = session.get(Product.class, productId);
		            if (product != null) {
		                orderItems.setProduct(product); // Set associated product
		            } else {
		                System.out.println("Product not found!");
		                return;
		            }

		            session.persist(orderItems); // ID will be auto-generated
		            transaction.commit();
		            System.out.println("Order item created with ID: " + orderItems.getItemid());
		        } catch (Exception e) {
		            transaction.rollback();
		            e.printStackTrace();
		        } finally {
		            session.close();
		        }
		    }

		    @Override
		    public void updateOrderItem(SessionFactory sf) {
		        Session session = sf.openSession();
		        Transaction transaction = session.beginTransaction();

		        try {
		            while (true) {
		                System.out.println("Choose option for update: \n1.Update Quantity\n2.Update Order\n3.Update Product\n4.Exit");

		                int option = sc.nextInt();
		                switch (option) {
		                    case 1:
		                        System.out.println("Enter order item ID:");
		                        OrderItems orderItem = session.get(OrderItems.class, sc.nextInt());
		                        if (orderItem == null) {
		                            System.out.println("Order item not found!");
		                            break;
		                        }
		                        System.out.println("Enter new quantity:");
		                        orderItem.setQuantity(sc.nextInt());
		                        session.saveOrUpdate(orderItem);
		                        break;

		                    case 2:
		                        System.out.println("Enter order item ID:");
		                        orderItem = session.get(OrderItems.class, sc.nextInt());
		                        if (orderItem == null) {
		                            System.out.println("Order item not found!");
		                            break;
		                        }
		                        System.out.println("Enter new order ID:");
		                        int orderId = sc.nextInt();
		                        Orders order = session.get(Orders.class, orderId);
		                        if (order != null) {
		                            orderItem.setOrders(order);
		                            session.saveOrUpdate(orderItem);
		                        } else {
		                            System.out.println("Order not found!");
		                        }
		                        break;

		                    case 3:
		                        System.out.println("Enter order item ID:");
		                        orderItem = session.get(OrderItems.class, sc.nextInt());
		                        if (orderItem == null) {
		                            System.out.println("Order item not found!");
		                            break;
		                        }
		                        System.out.println("Enter new product ID:");
		                        int productId = sc.nextInt();
		                        Product product = session.get(Product.class, productId);
		                        if (product != null) {
		                            orderItem.setProduct(product);
		                            session.saveOrUpdate(orderItem);
		                        } else {
		                            System.out.println("Product not found!");
		                        }
		                        break;

		                    case 4:
		                        System.out.println("Exiting from update order item");
		                        return;

		                    default:
		                        System.out.println("Choose the correct option");
		                        break;
		                }
		            }
		        } catch (Exception e) {
		            transaction.rollback();
		            e.printStackTrace();
		        } finally {
		            transaction.commit(); // Commit transaction outside of the loop
		            session.close();
		        }
		    }

		    @Override
		    public void deleteOrderItem(SessionFactory sf) {
		        Session session = sf.openSession();
		        Transaction transaction = session.beginTransaction();

		        try {
		            System.out.println("Enter order item ID:");
		            int itemId = sc.nextInt(); // Make sure to read the item ID from input
		            OrderItems orderItem = session.get(OrderItems.class, itemId);
		            if (orderItem != null) {
		                session.delete(orderItem);
		                System.out.println("Order item deleted successfully.");
		            } else {
		                System.out.println("Enter a valid order item ID.");
		            }
		            transaction.commit();
		        } catch (Exception e) {
		            transaction.rollback();
		            e.printStackTrace();
		        } finally {
		            session.close();
		        }
		    }

		    @Override
		    public void getOrderItemById(SessionFactory sf) {
		        Session session = sf.openSession();

		        try {
		            System.out.println("Enter order item ID:");
		            int itemId = sc.nextInt(); // Read item ID from input
		            OrderItems orderItem = session.get(OrderItems.class, itemId);
		            if (orderItem != null) {
		                System.out.println(orderItem);
		            } else {
		                System.out.println("Order item not found!");
		            }
		        } finally {
		            session.close();
		        }
		    }

		    @Override
		    public void getAllOrderItems(SessionFactory sf) {
		        Session session = sf.openSession();

		        try {
		            Query query = session.createQuery("from OrderItems", OrderItems.class);
		            List<OrderItems> resultList = query.getResultList();

		            for (OrderItems oi : resultList) {
		                System.out.println(oi);
		            }
		        } finally {
		            session.close();
		        }
		    }
		}

	


