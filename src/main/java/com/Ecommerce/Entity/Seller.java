package com.Ecommerce.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Seller")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sellerId;

    private String sellerName;

    private String GstNo;
    
    private long sellerPhoneNumber;
    
	@OneToOne
	@JoinColumn(name  = "user_id")
	private User user;
    
	@OneToMany
	@JoinColumn(name  = "SellerProduct_id")
    private List<ProductName> products;
    
    
    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

	public Seller() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seller(Long sellerId, String sellerName, String gstNo, long sellerPhoneNumber, List<ProductName> products,
			Date createdAt, Date updatedAt) {
		super();
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		GstNo = gstNo;
		this.sellerPhoneNumber = sellerPhoneNumber;
		this.products = products;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getGstNo() {
		return GstNo;
	}

	public void setGstNo(String gstNo) {
		GstNo = gstNo;
	}

	public long getSellerPhoneNumber() {
		return sellerPhoneNumber;
	}

	public void setSellerPhoneNumber(long sellerPhoneNumber) {
		this.sellerPhoneNumber = sellerPhoneNumber;
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
    
    
   
}
