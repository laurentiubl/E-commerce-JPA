package webBoot;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository

public class ProductService {
	
	@Autowired
	private ProductRep rep;
	
	
	
	public List<product> listAll(){
		
		return rep.findAll();
	}
	
	public void save(product pr) {
		
		rep.save(pr);
	}
	
	public product get(Long id) {
		return rep.findById(id).get();
	}
	
	public void del(Long id) {
		
		rep.deleteById(id);
	}
	
	
	}


