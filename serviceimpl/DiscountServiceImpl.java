package com.hibernate.serviceimpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.entity.Discount;
import com.hibernate.service.DiscountService;

public class DiscountServiceImpl implements DiscountService{

    Scanner sc = new Scanner(System.in);
    
    @Override
    public void createDiscount(SessionFactory sf) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Discount discount = new Discount();
            
            // Input for discount details
            System.out.println("Enter minimum quantity:");
            int minQuantity = sc.nextInt();
            discount.setMinQuantity(minQuantity);

            System.out.println("Enter discount amount:");
            double discountAmount = sc.nextDouble();
            discount.setDiscountAmount(discountAmount);

            System.out.println("Enter description:");
            sc.nextLine(); // Consume newline
            String description = sc.nextLine();
            discount.setDescription(description);

            session.persist(discount); // ID will be auto-generated
            transaction.commit();

            System.out.println("Discount created with ID: " + discount.getId());
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void updateDiscount(SessionFactory sf) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            System.out.println("Enter discount ID to update:");
            int id = sc.nextInt();
            Discount discount = session.get(Discount.class, id);
            if (discount != null) {
                System.out.println("Enter new minimum quantity:");
                discount.setMinQuantity(sc.nextInt());

                System.out.println("Enter new discount amount:");
                discount.setDiscountAmount(sc.nextDouble());

                System.out.println("Enter new description:");
                sc.nextLine(); // Consume newline
                discount.setDescription(sc.nextLine());

                session.update(discount);
                transaction.commit();
                System.out.println("Discount updated successfully.");
            } else {
                System.out.println("Discount not found!");
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteDiscount(SessionFactory sf) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            System.out.println("Enter discount ID to delete:");
            int id = sc.nextInt();
            Discount discount = session.get(Discount.class, id);
            if (discount != null) {
                session.delete(discount);
                transaction.commit();
                System.out.println("Discount deleted successfully.");
            } else {
                System.out.println("Discount not found!");
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Discount getDiscountById(SessionFactory sf) {
        Session session = sf.openSession();
        Discount discount = null;

        try {
            System.out.println("Enter discount ID:");
            int id = sc.nextInt();
            discount = session.get(Discount.class, id);
            if (discount != null) {
                System.out.println("Discount Details: " + discount);
            } else {
                System.out.println("Discount not found!");
            }
        } finally {
            session.close();
        }
        return discount; // Returning the found discount or null
    }

    @Override
    public List<Discount> getAllDiscounts(SessionFactory sf) {
        Session session = sf.openSession();
        List<Discount> discounts = null;

        try {
            Query query = session.createQuery("FROM Discount");
            discounts = query.getResultList();
            for (Discount discount : discounts) {
                System.out.println(discount);
            }
        } finally {
            session.close();
        }
        return discounts; // Returning the list of discounts
    }
}



