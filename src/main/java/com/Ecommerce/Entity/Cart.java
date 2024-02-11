package com.Ecommerce.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ShoppingCart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private User customer;


    // New columns for auditing
    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at") 
    private Date updatedAt;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Cart(Long cartId, User customer, Date createdAt, Date updatedAt) {
		super();
		this.cartId = cartId;
		this.customer = customer;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}



	public Long getCartId() {
		return cartId;
	}



	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}



	public User getCustomer() {
		return customer;
	}



	public void setCustomer(User customer) {
		this.customer = customer;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	 

	    

    // Constructors, getters, and setters
}
