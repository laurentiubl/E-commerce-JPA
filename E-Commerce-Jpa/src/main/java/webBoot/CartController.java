package webBoot;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/rest/cart")
public class CartController {
	
	
	
	@Autowired
	private CartDaoImpl cartDao;
	
	@Autowired
	ProductService prSer;
	
	
	@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
	public @ResponseBody Cart read(@PathVariable(value= "cartId") String cartId) {
		return cartDao.read(cartId);
	}
	
	
	@RequestMapping(value="/{cartId}", method= RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@PathVariable(value= "cartId") String cartId,@RequestBody Cart cart) {
		cartDao.update(cartId, cart);
	}
	
	@RequestMapping(value="/{cartId}", method= RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value="cartId") String cartId) {
		cartDao.delete(cartId);
	}
	
	@RequestMapping(value= "/add/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable(value= "productId") Long productId, HttpServletRequest request) {
		
		String sessionId = request.getSession(true).getId();
		Cart cart = cartDao.read(sessionId);
		
		if(cart == null) {
			cart = cartDao.create(new Cart(sessionId));
		}
		
		product pro = prSer.get(productId);
		if(pro ==null) {
			throw new IllegalArgumentException(new Exception());
		}
		
		cart.addCartItem(new CartItem(pro));
		
		cartDao.update(sessionId, cart);
	}
	
	
	@RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable Long productId, HttpServletRequest request) {
		String sessionId = request.getSession(true).getId();
		Cart cart = cartDao.read(sessionId);
		
		if(cart == null) {
			cart = cartDao.create(new Cart(sessionId));
		}
		
		product pro = prSer.get(productId);
		if(pro ==null) {
			throw new IllegalArgumentException(new Exception());
		}
		
		cart.removeCartItem(new CartItem(pro));
		
		cartDao.update(sessionId, cart);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "illegal request, please verify your payload")
	public void handleClientError(Exception e) {
		
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server error")
	public void handleServerError(Exception e) {
		
	}

}
