package com.Ecommerce.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.Ecommerce.DAO.OrderItemRespository;
import com.Ecommerce.DAO.OrderRepository;
import com.Ecommerce.DAO.ProductRepository;
import com.Ecommerce.DAO.UserRespository;
import com.Ecommerce.Entity.Cart;
import com.Ecommerce.Entity.CartItem;
import com.Ecommerce.Entity.OrderItem;
import com.Ecommerce.Entity.Orders;
import com.Ecommerce.Entity.ProductName;
import com.Ecommerce.ExceptionHandling.CartIdNotFoundException;
import com.Ecommerce.ExceptionHandling.CartItemEmptyException;
import com.Ecommerce.ExceptionHandling.OrderIdNotFoundException;
import com.Ecommerce.ExceptionHandling.OrderItemEmptyException;
import com.Ecommerce.ExceptionHandling.ProductNotFoundException;
import com.Ecommerce.ExceptionHandling.UserNotFoundException;
import com.Ecommerce.Util.AppConstant;


@Service
public class OrderItemImplementation implements OrderItemInterface{

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderItemRespository orderItemRespository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	UserRespository userRespository;
	


	@Override
		public String OrderProducts(Long productId, Long orderId, OrderItem orderItem) {
		
			if(productRepository.existsById(productId)) {
				ProductName product = productRepository.findByProductId(productId);
				
				if(orderRepository.existsById(orderId)) {
					Orders orders = orderRepository.findByOrderId(orderId);
					
					
					OrderItem orderItemDetails = new OrderItem();
					
					
					orderItemDetails.setOrder(orders);
					orderItemDetails.setCreatedAt(LocalDate.now());
					orderItemDetails.setProduct(product);
					//orderItemDetails.setProductUnitPrice(product.getProductCost());
					orderItemDetails.setProductquantity(orderItem.getProductquantity());
					double totalPrice = orderItemDetails.setTotalPurchasePrice(product.getProductCost() * orderItem.getProductquantity());
					
					orderItemRespository.save(orderItemDetails);
					
					
					return "Your order was placed successfully, and your total price is $" + totalPrice;
					
				}
				else {

					throw new OrderIdNotFoundException(AppConstant.OrderIdNotFound);
					
				}
				
				
			}
			else {
				
				throw new ProductNotFoundException(AppConstant.productIdNotFound);
				
			}
			
			
			
			
	}


	
	@Override
	public List<OrderItem> getAllOrderItemBasedOnCustomerId(Long customerId) {
		
		if(userRespository.existsById(customerId)) {

			UserDetails userDetails =  userRespository.findByCustomerId(customerId);
			
			Orders orderDetails = orderRepository.findByCustomer(userDetails);
			
			if(orderDetails != null) {
				if(orderRepository.existsById(orderDetails.getOrderId())) {
					
					List<OrderItem> orderItemDetails = orderItemRespository.findByOrder(orderDetails);
					
					if(orderItemDetails.isEmpty()) {
						
						throw new OrderItemEmptyException(AppConstant.OrderItemIsEmpty);
						
					}
					else {

						return orderItemDetails;
						
					}
					
					
				}
					else {
						throw new CartIdNotFoundException(AppConstant.OrderIdNotFound);
					}
				
			}
			else {
				throw new OrderIdNotFoundException(AppConstant.OrderIdNotFound);
			}
			
			
		}
		else {
			throw new UserNotFoundException(AppConstant.userLoginWrongCredentialsInfo);
		}
		
	}
	
	
	

	

}
