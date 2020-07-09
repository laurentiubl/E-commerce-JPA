package webBoot.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetail implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userName;
	
	private String PASSWORD;
	
	private boolean ACTIVE;
	
	private List<GrantedAuthority> authorities;
	
	
	public MyUserDetail(User user) {
		
		this.userName = user.getUserName();
		this.PASSWORD = user.getPASSWORD();
		this.ACTIVE = user.isACTIVE();
		this.authorities = Arrays.stream(user.getROLES().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return PASSWORD;
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return ACTIVE;
	}
	
	
}
