package com.ordermanagement.service;

import com.ordermanagement.entity.OrderDetails;
import com.ordermanagement.required.Restaurant;

public interface OrderService {
	
	OrderDetails addNewOrder(OrderDetails newOrder);
	
	OrderDetails findOrderDetailsById(long id);
	
	OrderDetails updateOrderDetailsById(long id, OrderDetails updateOrder);
	
	void deleteOrderById(long id);
	
	Restaurant getRestaueantDetailsById(long id);

}
