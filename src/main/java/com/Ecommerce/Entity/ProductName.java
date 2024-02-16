package com.Ecommerce.Entity;
import java.time.LocalDate;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "productName")
public class ProductName {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	private String productName;
	
	private String productImage1;
	
	private String productImage2;
	
	private String productImage3;
	
	private String productImage4;
	
	private Double productCost;
	
	private String description;
	
	private String productQuantity;
	
	
	
    @ManyToOne
    @JoinColumn(name = "categoryId",referencedColumnName = "categoryId")
    private CategoryType categoryType;
    	
    @Column(name = "created_at")
    private LocalDate createdAt;
     
    @Column(name = "updated_at")
    private LocalDate updatedAt;
    
    @ManyToOne
    @JoinColumn(name = "productSellerName",referencedColumnName = "sellerId")
    private Seller seller;

	public ProductName() {
		super();
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage1() {
		return productImage1;
	}

	public void setProductImage1(String productImage1) {
		this.productImage1 = productImage1;
	}

	public String getProductImage2() {
		return productImage2;
	}

	public void setProductImage2(String productImage2) {
		this.productImage2 = productImage2;
	}

	public String getProductImage3() {
		return productImage3;
	}

	public void setProductImage3(String productImage3) {
		this.productImage3 = productImage3;
	}

	public String getProductImage4() {
		return productImage4;
	}

	public void setProductImage4(String productImage4) {
		this.productImage4 = productImage4;
	}

	public Double getProductCost() {
		return productCost;
	}

	public void setProductCost(Double productCost) {
		this.productCost = productCost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CategoryType getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(CategoryType categoryType) {
		this.categoryType = categoryType;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public String getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(String productQuantity) {
		this.productQuantity = productQuantity;
	}
		
	
	
	
	

}
