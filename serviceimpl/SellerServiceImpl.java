package com.hibernate.serviceimpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.entity.Admin;
import com.hibernate.entity.Seller;
import com.hibernate.service.SellerService;

public class SellerServiceImpl implements SellerService {

	Scanner sc=new Scanner(System.in);
	
	public void createSeller(SessionFactory sf) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Seller seller = new Seller();
            System.out.println("Enter values for seller: sellername and password:");

            seller.setSellername(sc.next()); // Set seller name
            seller.setPassword(sc.next()); // Set password

            // Fetch existing Admin by ID
            System.out.println("Enter admin id for this seller:");
            int adminId = sc.nextInt();
            Admin admin = session.get(Admin.class, adminId);
            if (admin == null) {
                System.out.println("Admin not found. Seller cannot be created without a valid admin.");
                return;
            }
            seller.setAdmin(admin); // Set the associated Admin

            session.persist(seller);
            transaction.commit();
            System.out.println("Seller created with ID: " + seller.getId());
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateSeller(SessionFactory sf) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            System.out.println("Enter seller id to update:");
            Seller seller = session.get(Seller.class, sc.nextInt());
            if (seller == null) {
                System.out.println("Seller not found!");
                return;
            }

            System.out.println("Choose option to update:\n1. Seller Name\n2. Password\n3. Admin ID\n4. Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter new seller name:");
                    seller.setSellername(sc.next());
                    break;
                case 2:
                    System.out.println("Enter new password:");
                    seller.setPassword(sc.next());
                    break;
                case 3:
                    System.out.println("Enter new admin ID:");
                    int adminId = sc.nextInt();
                    Admin admin = session.get(Admin.class, adminId);
                    if (admin == null) {
                        System.out.println("Admin not found. Admin ID cannot be updated.");
                        return;
                    }
                    seller.setAdmin(admin); // Update the associated Admin
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option.");
                    return;
            }

            session.saveOrUpdate(seller);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteSeller(SessionFactory sf) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            System.out.println("Enter seller id to delete:");
            int id = sc.nextInt();
            Seller seller = session.get(Seller.class, id);
            if (seller != null) {
                session.delete(seller);
                transaction.commit();
                System.out.println("Seller deleted successfully.");
            } else {
                System.out.println("Seller not found.");
            }
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void getSellerById(SessionFactory sf) {
        Session session = sf.openSession();
        try {
            System.out.println("Enter seller id to retrieve:");
            int id = sc.nextInt();
            Seller seller = session.get(Seller.class, id);
            if (seller != null) {
                System.out.println(seller);
            } else {
                System.out.println("Seller not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void getAllSellers(SessionFactory sf) {
        Session session = sf.openSession();
        try {
            Query query = session.createQuery("from Seller");
            List<Seller> resultList = query.getResultList();
            for (Seller s : resultList) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
        public boolean authenticateSeller(SessionFactory sf, String sellername, String password) {
            Session session = sf.openSession();
            boolean isAuthenticated = false;

            try {
                String hql = "FROM Seller WHERE sellername = :sellername AND password = :password";
                Query<Seller> query = session.createQuery(hql, Seller.class);
                query.setParameter("sellername", sellername);
                query.setParameter("password", password);

                Seller seller = query.uniqueResult();
                if (seller != null) {
                    isAuthenticated = true;
                    System.out.println("Seller authenticated successfully.");
                } else {
                    System.out.println("Invalid seller credentials.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                session.close();
            }

            return isAuthenticated;
        }
    }
   


