package com.Ecommerce.Service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.DAO.CartRepository;
import com.Ecommerce.Entity.Cart;
import com.Ecommerce.Entity.User;

@Service
public class CartServiceImplementation implements CartServiceInterface{
	
	Cart cart;
	
	@Autowired
	CartRepository cartRepository;

	@Override
	public void addCartDetails(User user) {
		
		Cart cart = new Cart();
		
		cart.setCustomer(user);
		cart.setCreatedAt(LocalDate.now());
		cartRepository.save(cart);		
	}

	

//	@Override
//	public String addToCart(long userid, long cartItemId, int quantity, ProductName product) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	
//	@Autowired
//	CartRepository cartRepository;
//
//	@Autowired
//	CartItemRespository cartItemRespository;
//	
//	@Autowired
//	User user;
//	UserRespository userrespository;
//	
//	@Autowired
//	ProductRepository productRepository;
//	
//	
//	
//        public  String addToCart(long userId,long cartItemId, int quantity, ProductName product) {
//	    // Retrieve the user's cart from the database
//	    Optional<User> userDetails = userrespository.findById(userId);
//	    
//	    // Check if the user exists
//	    if (!userDetails.isPresent()) {
//	        throw new UserNotFoundException("User not found. Please log in.");
//	    }
//
//	    // Check if the product already exists in the cart
//	    Boolean isProductInCart = cartItemRespository.existsByUserIdAndCartIdAndProductId(userId,cartItemId, product.getProductId());
//	    //Integer existingProductQuantity = cartRepository.findProductQuantityBasedOnProductIdInCart(product.getProductId()); 
//
//	    // If the product already exists in the cart, update the quantity
//	    if (isProductInCart != null && isProductInCart) {
//	    	// If the product already exists in the cart, return a message indicating that the product is already in the cart
//	    	if (isProductInCart != null && isProductInCart) {
//	    	    return "Product is already in the cart";
//	    	} 
//
//	    } 
//
//	    // If the product doesn't exist in the cart, add it
//	    // Retrieve the user's cart
////	    Optional<Cart >userCart = Optional.empty();
//
//	    // Retrieve product information
//	    Optional<ProductName> productInfo = productRepository.findById(product.getProductId());
//	    if (productInfo.isPresent()) {
//	        // Create a new item for the cart
//	        CartItem newItem = new CartItem();
//	        newItem.setCartItemId(cartItemId);
//	        newItem.setProduct(product);
//	        newItem.setProductquantity(quantity);
//	        
//	        // Add the new item to the user's cart
//	        //userCart.get.add(newItem);
//	        
//	        // Save the updated user's cart
//	        cartItemRespository.save(newItem);
//	        
//	        return "Product added to cart successfully";
//	    } else {
//	        throw new ProductNotFoundException("Product not found.");
//	    }
//	}

//	
//	
//	
	
	
	
	
	
//	
//
//	@Override
//	public List<ProductName> viewAllProducts() {
//		List<Cart> CartList = cartRepository.findAll();
//		
//		return null;
//	}
//
//
//
//	@Override
//	public int addQuantityOfTheProduct() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//
//
//
//	@Override
//	public void removeFromCart(Long userId, Long productId) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void updateCartQuantity(Long userId, Long productId, int newQuantity) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public double calculateTotalCartAmount(Long userId) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//
//
//
//
//
//
//
//
//
//
//	@Override
//	public int calculateTotalPrice(ProductName product, Cart cart) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//
//
//
//
//
//
//
//
//
//
//	@Override
//	public void removeAllTheProductsFromCart() {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//
//
//	@Override
//	public String addToCart(long userid, long cartItemId, int quantity, ProductName product) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//



}
