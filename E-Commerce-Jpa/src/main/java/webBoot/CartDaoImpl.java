package webBoot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;


@Repository
public class CartDaoImpl implements CartDao{

	
	private Map<String, Cart> listOfCarts;
	

	public CartDaoImpl() {
		listOfCarts = new HashMap<String, Cart>();
	}
	

	@Override
	public Cart create(Cart cart) {
		
		if(listOfCarts.keySet().contains(cart.getCartId())) {
			throw new IllegalArgumentException(String.format("Nu poti crea cart cu acest session, exista deja" + cart.getCartId()));
			
		}
		
		listOfCarts.put(cart.getCartId(), cart);
		
		return cart;
	}

	@Override
	public Cart read(String cartId) {
		
		return listOfCarts.get(cartId);
	}

	
	@Override
	public void update(String cartId, Cart cart) {
		
		if(!listOfCarts.keySet().contains(cartId))
		{
			throw new IllegalArgumentException(String.format("Nu poti face update cart cu acest id, nu exista " + cart.getCartId()));
		
		}
		listOfCarts.put(cartId, cart);
	}

	@Override
	public void delete(String cartId) {
	
		if(!listOfCarts.keySet().contains(cartId))
		{
			throw new IllegalArgumentException(String.format("Nu poti sa stergi acest cart,Cardul cu id ul " + cartId));
		}
		listOfCarts.remove(cartId);
	}

	
	
}
