package com.Ecommerce.DTO;


import org.springframework.stereotype.Component;

@Component
public class LoginDetails {
	
	public String token;
	
	public Long customerId;
	
	public boolean isSellerOrNot;
	
	public String customerName;
	
	public String MessageInfo;

	public LoginDetails(String token, Long customerId, boolean isSellerOrNot, String customerName) {
		super();
		this.token = token;
		this.customerId = customerId;
		this.isSellerOrNot = isSellerOrNot;
		this.customerName = customerName;
	}

	public LoginDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	

	public void setSellerOrNot(boolean isSellerOrNot) {
		this.isSellerOrNot = isSellerOrNot;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public void setMessageInfo(String messageInfo) {
		MessageInfo = messageInfo;
	}
	
	
	
	

}
