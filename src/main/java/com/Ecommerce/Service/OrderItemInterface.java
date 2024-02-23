package com.Ecommerce.Service;

import java.util.List;

import com.Ecommerce.Entity.OrderItem;

public interface OrderItemInterface {
	
	

	public String OrderProducts(Long productId,Long orderId,OrderItem orderItem);
	
	
	public List<OrderItem> getAllOrderItems();
} 
