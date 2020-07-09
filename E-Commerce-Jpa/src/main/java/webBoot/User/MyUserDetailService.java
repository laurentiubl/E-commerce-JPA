package webBoot.User;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class MyUserDetailService implements UserDetailsService{

	@Autowired
	UserRep userRep;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
	  Optional<User> user=	userRep.findByUserName(userName);
	  
	  user.orElseThrow(()-> new UsernameNotFoundException("User nu s a gasit" + userName) );
	  
	  return user.map(MyUserDetail::new).get();
	}

	
	
	
}
