package com.hibernate.serviceimpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.entity.Admin;
import com.hibernate.service.AdminService;

public class AdminServiceImpl  implements AdminService{
	
	private Scanner sc = new Scanner(System.in);

    public void createAdmin(SessionFactory sf) {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                Admin admin = new Admin();

                System.out.println("Enter values for admin: username, password, and email:");
                admin.setUsername(sc.next());
                admin.setPassword(sc.next());
                admin.setEmail(sc.next());

                session.persist(admin);
                transaction.commit();

                System.out.println("Admin created with ID: " + admin.getId());
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
            }
        }
    }

    public void updateAdmin(SessionFactory sf) {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                while (true) {
                    System.out.println("Choose option for update \n1.Update Username\n2.Update Password\n3.Update Email\n4.Exit");
                    int option = sc.nextInt();
                    if (option == 4) {
                        System.out.println("Exiting update admin.");
                        break;
                    }

                    System.out.println("Enter admin id:");
                    int adminId = sc.nextInt();
                    Admin admin = session.get(Admin.class, adminId);
                    if (admin == null) {
                        System.out.println("Admin not found!");
                        continue;
                    }

                    switch (option) {
                        case 1:
                            System.out.println("Enter new username:");
                            admin.setUsername(sc.next());
                            break;
                        case 2:
                            System.out.println("Enter new password:");
                            admin.setPassword(sc.next());
                            break;
                        case 3:
                            System.out.println("Enter new email:");
                            admin.setEmail(sc.next());
                            break;
                        default:
                            System.out.println("Choose the correct option.");
                            continue;
                    }

                    session.update(admin); // Persist changes in database
                    transaction.commit();
                    transaction = session.beginTransaction(); // Restart transaction for next update
                }
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
            }
        }
    }

    public void deleteAdmin(SessionFactory sf) {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                System.out.println("Enter admin id:");
                int id = sc.nextInt();

                Admin admin = session.get(Admin.class, id);
                if (admin != null) {
                    session.delete(admin);
                    System.out.println("Admin deleted successfully.");
                    transaction.commit();
                } else {
                    System.out.println("Enter a valid admin id.");
                }
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
            }
        }
    }

    public void getAdminById(SessionFactory sf) {
        try (Session session = sf.openSession()) {
            System.out.println("Enter admin id:");
            int id = sc.nextInt();

            Admin admin = session.get(Admin.class, id);
            if (admin != null) {
                System.out.println(admin);
            } else {
                System.out.println("Admin not found!");
            }
        }
    }

    public void getAllAdmins(SessionFactory sf) {
        try (Session session = sf.openSession()) {
            Query<Admin> query = session.createQuery("from Admin", Admin.class);
            List<Admin> resultList = query.getResultList();

            for (Admin a : resultList) {
                System.out.println(a);
            }
        }
    }

    public boolean authenticateAdmin(SessionFactory sf, String username, String password) {
        try (Session session = sf.openSession()) {
            Admin admin = session.createQuery("FROM Admin WHERE username = :username AND password = :password", Admin.class)
                    .setParameter("username", username)
                    .setParameter("password", password) // Use hashed passwords in real applications
                    .uniqueResult();

            return admin != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}