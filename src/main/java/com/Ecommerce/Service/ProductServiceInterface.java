package com.Ecommerce.Service;

import java.util.List;

import com.Ecommerce.Entity.ProductName;

public interface ProductServiceInterface {

   
  public List<ProductName> getProductsInCart(Long userId);
}
