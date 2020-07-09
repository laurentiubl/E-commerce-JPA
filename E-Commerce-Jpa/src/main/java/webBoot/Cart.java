package webBoot;

import java.util.HashMap;
import java.util.Map;

public class Cart {

	
	private String cartId;
	
	private Map<String, CartItem> cartItem;
	
	private double grandTotal;
	
	private Cart() {
		cartItem = new HashMap<String, CartItem>();
		grandTotal = 0;
	}
	
	public Cart(String cartId) {
		this();
		this.cartId= cartId;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public Map<String, CartItem> getCartItem() {
		return cartItem;
	}

	public void setCartItem(Map<String, CartItem> cartItem) {
		this.cartItem = cartItem;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	public void addCartItem(CartItem item) {
		
		long productId = item.getPr().getId();
		
		String prId = Long.toString(productId);
		
		if(cartItem.containsKey(prId)) {
			
			CartItem existingCartItem = cartItem.get(prId);
			existingCartItem.setQuantity(existingCartItem.getQuantity() + item.getQuantity());
			cartItem.put(prId, existingCartItem);
			
		}else {
			cartItem.put(prId, item);
		}
		updateGrandTotal();
	}
	
	public void removeCartItem(CartItem item) {
		
		long productId = item.getPr().getId();
		String prId = Long.toString(productId);
		
		cartItem.remove(prId);
		
		updateGrandTotal();
	}
	
	
	public void updateGrandTotal() {
		
		grandTotal= 0;
		
		for(CartItem item: cartItem.values()) {
			grandTotal= grandTotal+item.getTotalPrice();
		}
	}
	
	
}
