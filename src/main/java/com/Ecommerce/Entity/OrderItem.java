package com.Ecommerce.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "OrderItem")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    @OneToOne
    @JoinColumn(name = "orderId",referencedColumnName = "orderId")
    private Orders order;
    
     
    @ManyToOne
    @JoinColumn(name = "OrderProductId")
    private ProductName product;

    private int Productquantity;
    
    private double ProdcuctUnitPrice;
    
    
    private double TotalPurchasePrice;
    
    


	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}



	public OrderItem(Long orderItemId, Orders order, ProductName product, int productquantity, double prodcuctUnitPrice,
			double totalPurchasePrice) {
		super();
		this.orderItemId = orderItemId;
		this.order = order;
		this.product = product;
		Productquantity = productquantity;
		ProdcuctUnitPrice = prodcuctUnitPrice;
		TotalPurchasePrice = totalPurchasePrice;
	}
	
	
	public ProductName getProduct() {
		return product;
	}



	public void setProduct(ProductName product) {
		this.product = product;
	}



	public Long getOrderItemId() {
		return orderItemId;
	}




	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}




	public Orders getOrder() {
		return order;
	}




	public void setOrder(Orders order) {
		this.order = order;
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
    
	
    

    // Constructors, getters, and setters
}
