package com.Ecommerce.Service;

import com.Ecommerce.Entity.OrderItem;

public interface OrderItemInterface {
	
	

	public String OrderProducts(Long productId,Long orderId,OrderItem orderItem);
} 
