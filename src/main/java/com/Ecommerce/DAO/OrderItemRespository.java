package com.Ecommerce.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.Entity.OrderItem;

public interface OrderItemRespository extends JpaRepository<OrderItem,Long>{

}
