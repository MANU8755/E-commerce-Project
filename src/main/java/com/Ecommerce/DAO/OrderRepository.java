package com.Ecommerce.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.Entity.Orders;

public interface OrderRepository extends JpaRepository<Orders,Long>{
	
	public Orders findByOrderId(Long orderId);

}
