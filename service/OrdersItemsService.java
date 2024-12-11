package com.hibernate.service;

import org.hibernate.SessionFactory;

public interface OrdersItemsService {

	void createOrderItem(SessionFactory sf);
    void updateOrderItem(SessionFactory sf);
    void deleteOrderItem(SessionFactory sf);
    void getOrderItemById(SessionFactory sf);
    void getAllOrderItems(SessionFactory sf);
}


