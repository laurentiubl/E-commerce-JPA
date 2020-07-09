package webBoot;

public class CartItem {

	
	private product pr;
	
	private int quantity;
	
	private double totalPrice;
	
	public CartItem() {}

	public CartItem(product pr) {
	
		this.pr = pr;
		this.quantity = 1;
		this.totalPrice = pr.getPrice();
	}

	public product getPr() {
		return pr;
	}

	public void setPr(product pr) {
		this.pr = pr;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
	
	
}
