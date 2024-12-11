package com.hibernate.entity;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.serviceimpl.AdminServiceImpl;
import com.hibernate.serviceimpl.CustomerServiceImpl;
import com.hibernate.serviceimpl.DiscountServiceImpl;
import com.hibernate.serviceimpl.OrderItemServiceImpl;
import com.hibernate.serviceimpl.OrderServiceImpl;
import com.hibernate.serviceimpl.ProductServiceImpl;
import com.hibernate.serviceimpl.SellerServiceImpl;

public class Supermain {
	public static void main(String[] args) {

		SessionFactory getsFactory = ConfigurationUtility.getsFactory();
		Session Session = getsFactory.openSession();
		Transaction transaction = Session.beginTransaction();
		Scanner sc = new Scanner(System.in);
		/* * Admin admin = new Admin(); admin.setId(1); // Set a unique ID
		 * admin.setUsername("vyshu"); admin.setPassword("Password"); // Consider
		 * hashing for security admin.setEmail("admin@example.com");
		 */
        

        /*Admin admin = new Admin();
        admin.setId(4);
        admin.setUsername("rahul");
        admin.setPassword("rahul@08");
        admin.setEmail("rahulmallepelly@gmail.com");
        
        Session.save(admin);

        Seller seller = new Seller();
        seller.setId(4);
        seller.setSellername("divya");
        seller.setPassword("div@gmail.com");
        seller.setAdmin(admin); // Set the relationship

        // Save the Seller
        Session.save(seller);

        transaction.commit();

		Session.close();
		getsFactory.close();*/
        // Display welcome message
	       System.out.println("**********************************************");
	        System.out.println("   Welcome to the Supermarket Management System");
	        System.out.println("**********************************************");
	        System.out.println("Please select a menu option to get started.");

	try {
		while(true) {
			System.out.println("select option:\n1.Admin menu\n2.Seller menu\n3.customer menu\n4.product menu\n5.Discount menu\n6.Order menu\n7.OrderItems Menu\n8.exit");
			int mainOption=sc.nextInt();
			switch(mainOption) {
			case 1:{
				
				AdminServiceImpl adminservice=new AdminServiceImpl();
				while(true) {
					   System.out.println("Select option \n1.Insert Admin 2.Update Admin 3.Delete Admin 4.Select All Admins 5.Select an Admin 6.back");
					   int option=sc.nextInt();
					   switch(option) {
					   case 1:
			                adminservice.createAdmin(getsFactory);
			                break;
			            case 2:
			                adminservice.updateAdmin(getsFactory);
			                break;
			            case 3:
			                adminservice.deleteAdmin(getsFactory);
			                break;
			            case 4:
			                adminservice.getAllAdmins(getsFactory);
			                break;
			            case 5:
			                adminservice.getAdminById(getsFactory);
			                break;
	                    case 6:
	                        break; // Exit admin menu
	                    default:
	                        System.out.println("Choose a valid option.");
	                        break;

			        }
					   if (option == 6) break; // Exit the admin loop
	            }
	            break; // Exit the main switch for admin menu
	        }
			case 2:
			{
				SellerServiceImpl sellerService = new SellerServiceImpl();
				while(true) {
				
				
					System.out.println("Select option \n1.Create Seller 2.Update Seller 3.Delete Seller 4.Select All Sellers 5.Select a Seller 6.Back");
					
					int option=sc.nextInt();
					switch(option) {
					case 1:
						sellerService.createSeller(getsFactory);
						break;
					case 2:
						sellerService.updateSeller(getsFactory);
						break;
					case 3:
						sellerService.deleteSeller(getsFactory);
						break;
					case 4:
						sellerService.getAllSellers(getsFactory);
						break;
					case 5:
						sellerService.getSellerById(getsFactory);
						break;
					case 6:
						break;
						default:
							System.out.println("choose a valid option");
					}
					if(option==6)break;
					
						
					}
				break;
							}
			case 3: {
	            CustomerServiceImpl customerService = new CustomerServiceImpl();
	            while (true) {
	                System.out.println("Select option \n1. Create Customer 2. Update Customer 3. Delete Customer 4. Select All Customers 5. Select a Customer 6. Back");
	                int option = sc.nextInt();
	                switch (option) {
	                    case 1:
	                        customerService.createCustomer(getsFactory);
	                        break;
	                    case 2:
	                        customerService.updateCustomer(getsFactory);
	                        break;
	                    case 3:
	                        customerService.deleteCustomer(getsFactory);
	                        break;
	                    case 4:
	                        customerService.getAllCustomers(getsFactory);
	                        break;
	                    case 5:
	                        customerService.getAllCustomers(getsFactory);
	                        break;
	                    case 6:
	                        break; // Exit customer menu
	                    default:
	                        System.out.println("Choose a valid option.");
	                        break;
	                }
	                if (option == 6) break; // Exit the customer loop
	            }
	            break; // Exit the main switch for customer menu
	        }
			case 4: {
	            ProductServiceImpl productService = new ProductServiceImpl();
	            while (true) {
	                System.out.println("Select option \n1. Create product 2. Update product 3. Delete product 4. Select All products 5. Select a Product 6. Back");
	                int option = sc.nextInt();
	                switch (option) {
	                    case 1:
	                        productService.createProduct(getsFactory);
	                        break;
	                    case 2:
	                    	 productService.updateProduct(getsFactory);
	                        break;
	                    case 3:
	                    	 productService.deleteProduct(getsFactory);
	                        break;
	                    case 4:
	                    	 productService.getAllProducts(getsFactory);
	                        break;
	                    case 5:
	                    	 productService.getProductById(getsFactory);
	                        break;
	                    case 6:
	                        break; // Exit customer menu
	                    default:
	                        System.out.println("Choose a valid option.");
	                        break;
	                }
	                if (option == 6) break; // Exit the customer loop
	            }
	            break; // Exit the main switch for customer menu
	        }
			case 5: {
	            DiscountServiceImpl discountService = new DiscountServiceImpl();
	            while (true) {
	                System.out.println("Select option \n1. Create discount 2. Update discount 3. Delete dicount 4. Select All discount 5. Select a discount 6. Back");
	                int option = sc.nextInt();
	                switch (option) {
	                    case 1:
	                        discountService.createDiscount(getsFactory);
	                        break;
	                    case 2:
	                    	 discountService.updateDiscount(getsFactory);
	                        break;
	                    case 3:
	                    	 discountService.deleteDiscount(getsFactory);
	                        break;
	                    case 4:
	                    	 discountService.getAllDiscounts(getsFactory);
	                        break;
	                    case 5:
	                    	 discountService.getDiscountById(getsFactory);
	                        break;
	                    case 6:
	                        break; // Exit customer menu
	                    default:
	                        System.out.println("Choose a valid option.");
	                        break;
	                }
	                if (option == 6) break; // Exit the customer loop
	            }
	            break; // Exit the main switch for customer menu
			}
			case 6: {
	            OrderServiceImpl orderService = new OrderServiceImpl();
	            while (true) {
	                System.out.println("Select option \n1. Create order 2. Update order 3. Delete order 4. Select All orders 5. Select a order 6.get order by seller id 7.get order by customer id 8.6"
	                		+ "1"
	                		+ " Back");
	                		
	                int option = sc.nextInt();
	                switch (option) {
	                    case 1:
	                        orderService.createOrder(getsFactory);
	                        break;
	                    case 2:
	                    	orderService.updateOrder(getsFactory);
	                        break;
	                    case 3:
	                    	 orderService.deleteOrder(getsFactory);
	                        break;
	                    case 4:
	                    	 orderService.getAllOrders(getsFactory);
	                        break;
	                    case 5:
	                    	 orderService.getOrderById(getsFactory);
	                        break;
	                    case 6:
	                    	orderService.getOrdersByCustomerId(getsFactory);
	                        break; // Exit customer menu
	                    case 7:
	                    	orderService.getOrdersBySellerId(getsFactory);
	                        break; // Exit customer menu
	                    case 8:
	                    	break;
	                    default:
	                        System.out.println("Choose a valid option.");
	                        break;
	                }
	                if (option == 8) break; // Exit the customer loop
	            }
	            break; // Exit the main switch for customer menu
			}
			case 7: {
	            OrderItemServiceImpl OrderItemsService = new  OrderItemServiceImpl();
	            while (true) {
	                System.out.println("Select option \n1. Create orderItems 2. Update OrderItems3. Delete OrderItems4. Select All OrderItems 5. Select a OrderItems 6. Back");
	                int option = sc.nextInt();
	                switch (option) {
	                    case 1:
	                    	OrderItemsService.createOrderItem(getsFactory);
	                        break;
	                    case 2:
	                    	OrderItemsService.deleteOrderItem(getsFactory);
	                        break;
	                    case 3:
	                    	OrderItemsService.updateOrderItem(getsFactory);
	                        break;
	                    case 4:
	                    	OrderItemsService.getAllOrderItems(getsFactory);
	                        break;
	                    case 5:
	                    	OrderItemsService.getOrderItemById(getsFactory);                 
	                    	break;
	                    case 6:
	                        break; // Exit customer menu
	                    default:
	                        System.out.println("Choose a valid option.");
	                        break;
	                }
	                if (option == 6) break; // Exit the customer loop
	            }
	            break; // Exit the main switch for customer menu
			}
			case 8:
	            System.out.println("Exiting the application.");
	            return; // Exit the main loop
	        default:
	            System.out.println("Choose a valid main option.");
	            break;
	            
			
	    }

			
			}
		}

			 catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            if (sc != null) {
		                sc.close(); // Close the Scanner in case of an error
		            }
		            if (getsFactory != null) {
		                getsFactory.close(); // Close SessionFactory in case of an error
		            }
			}
			}
	}



			//	TeacherServiceImp2l teacherService=new TeacherServiceImpl();

			

