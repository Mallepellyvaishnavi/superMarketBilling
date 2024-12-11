package com.hibernate.service;

import java.util.List;

import org.hibernate.SessionFactory;

import com.hibernate.entity.Discount;

public interface DiscountService {

		void createDiscount(SessionFactory sf);
		void updateDiscount(SessionFactory sf);
		void deleteDiscount(SessionFactory sf);
		 Discount getDiscountById(SessionFactory sf);
		 List<Discount> getAllDiscounts(SessionFactory sf);
		}


