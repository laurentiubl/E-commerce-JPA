package webBoot;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class AppController {

	@Autowired
	private ProductService prSer;
	
	
	   @RequestMapping("/")
	    public String home() {
	        return "home";
	    }
	   
	   @RequestMapping("/admin")
	    public String admin() {
	        return "admin";
	    }
	   
	// GET: Show Login Page
	   @RequestMapping(value = { "/admin/login" }, method = RequestMethod.GET)
	   public String login(Model model) {
	   return "login";
	   }
	
	   
	@RequestMapping("/produse")
	public String viewPageHome(Model model) {
		List<product> listProducts = prSer.listAll();		
		model.addAttribute("listProductss", listProducts);
		return "produse";
		
	}
	
	@RequestMapping("/produse/viewPr/{id}")
	public String viewProductt(@PathVariable long id, Model model )throws IOException{
		product product = prSer.get(id);
		model.addAttribute(product);
		
		return "viewPr";
		
	}
	
	
	
	
	@RequestMapping ("/admin/productInventory")
	public String productInv(Model model) {
		List<product> produseLista= prSer.listAll();
		model.addAttribute("produ", produseLista);
		
		return "productInventory";
	}
	
	
	@RequestMapping("/admin/productInventory/newProduct")
	public String showNewPro(Model model) {
		product pr = new product();
		model.addAttribute("pr" , pr);
		return "newProduct";
	}

	@RequestMapping(value = "/newProduct", method= RequestMethod.POST)
	public String saveProduct(@Valid @ModelAttribute("pr") product pr, BindingResult result) {
		
		if(result.hasErrors()) {
			return "newProduct";
		}
		prSer.save(pr);
		return "redirect:/";
	}
	
	@RequestMapping("/admin/productInventory/viewPr/{id}")
	public String viewProduct(@PathVariable long id, Model model )throws IOException{
		product product = prSer.get(id);
		model.addAttribute(product);
		
		return "viewPr";
		
	}
	
	
	@RequestMapping("/admin/produse/viewPr/{id}")
	public String viewProduct2(@PathVariable long id, Model model )throws IOException{
		product product = prSer.get(id);
		model.addAttribute(product);
		
		return "viewPr";
		
	}
	
	
	@RequestMapping("/admin/productInventory/deleteProduct/{id}")
	public String deletePr(@PathVariable long id, Model model) {
		prSer.del(id);
		return "redirect:/";
	}
	
}
