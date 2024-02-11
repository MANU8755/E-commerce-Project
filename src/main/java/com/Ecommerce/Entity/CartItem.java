package com.Ecommerce.Entity;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;


@Entity
public class CartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartItemId;
	
	
	@ManyToOne
    @JoinColumn(name = "CartProduct_id")
    private ProductName product;

	@OneToOne
	@JoinColumn(name = "cartId",referencedColumnName = "cartId")
	private Cart cart;
	    
	@ManyToOne
	@JoinColumn(name = "customerId",referencedColumnName = "customerId")
	private User user;

    private int Productquantity;
    
    private double ProdcuctUnitPrice;
    
    
    private double TotalPurchasePrice;

	    
	
    private Date createdAt;

    
    private Date updatedAt;
    
    
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CartItem(Long cartItemId, ProductName product, Cart cart, int productquantity, double prodcuctUnitPrice,
			double totalPurchasePrice, Date createdAt, Date updatedAt) {
		super();
		this.cartItemId = cartItemId;
		this.product = product;
		this.cart = cart;
		Productquantity = productquantity;
		ProdcuctUnitPrice = prodcuctUnitPrice;
		TotalPurchasePrice = totalPurchasePrice;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}


	public Long getCartItemId() {
		return cartItemId;
	}


	public void setCartItemId(Long cartItemId) {
		this.cartItemId = cartItemId;
	}





	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public int getProductquantity() {
		return Productquantity;
	}


	public void setProductquantity(int productquantity) {
		Productquantity = productquantity;
	}


	public double getProdcuctUnitPrice() {
		return ProdcuctUnitPrice;
	}


	public void setProdcuctUnitPrice(double prodcuctUnitPrice) {
		ProdcuctUnitPrice = prodcuctUnitPrice;
	}


	public double getTotalPurchasePrice() {
		return TotalPurchasePrice;
	}


	public void setTotalPurchasePrice(double totalPurchasePrice) {
		TotalPurchasePrice = totalPurchasePrice;
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


	public ProductName getProduct() {
		return product;
	}


	public void setProduct(ProductName product) {
		this.product = product;
	}
     
	
    
    

}
