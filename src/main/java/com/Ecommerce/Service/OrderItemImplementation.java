package com.Ecommerce.Service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.DAO.OrderItemRespository;
import com.Ecommerce.DAO.OrderRepository;
import com.Ecommerce.DAO.ProductRepository;
import com.Ecommerce.Entity.OrderItem;
import com.Ecommerce.Entity.Orders;
import com.Ecommerce.Entity.ProductName;


@Service
public class OrderItemImplementation implements OrderItemInterface{

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderItemRespository orderItemRespository;
	
	@Autowired
	ProductRepository productRepository;
	


	@Override
		public String OrderProducts(Long productId, Long orderId, OrderItem orderItem) {
			
	
			ProductName product = productRepository.findByProductId(productId);
			
			Orders orders = orderRepository.findByOrderId(orderId);
			
			
			OrderItem orderItemDetails = new OrderItem();
			
			
			orderItemDetails.setOrder(orders);
			orderItemDetails.setCreatedAt(LocalDate.now());
			orderItemDetails.setProduct(product);
			Double orderUnitPrice = orderItemDetails.setProductUnitPrice(orderItem.getProductUnitPrice());
			orderItemDetails.setProductquantity(orderItem.getProductquantity());
			double totalPrice = orderItemDetails.setTotalPurchasePrice(orderUnitPrice * orderItem.getProductquantity());
			
			orderItemRespository.save(orderItemDetails);
			
			
			return "Your order was placed successfully, and your total price is $" + totalPrice;
			
			
	}
	
	

	

}
