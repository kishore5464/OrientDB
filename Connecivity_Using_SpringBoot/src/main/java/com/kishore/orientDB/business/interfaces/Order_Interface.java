package com.kishore.orientDB.business.interfaces;

import java.util.List;

import com.kishore.orientDB.models.Orders;

public interface Order_Interface {

	List<Orders> getAllOrders();
	
	Orders insertOrder(Orders orders);
}
