package com.hibernate.service;

import java.util.List;

import org.hibernate.SessionFactory;

import com.hibernate.entity.Orders;

public interface OrdersService {
	


void createOrder(SessionFactory sf);
void updateOrder(SessionFactory sf);
void deleteOrder(SessionFactory sf);
void getOrderById(SessionFactory sf);
void getAllOrders(SessionFactory sf);
List<Orders> getOrdersByCustomerId(SessionFactory sf);	
List<Orders> getOrdersBySellerId(SessionFactory sf) ;
}