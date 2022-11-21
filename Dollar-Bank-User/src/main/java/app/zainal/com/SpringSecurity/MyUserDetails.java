package app.zainal.com.SpringSecurity;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import app.zainal.com.model.BankUser;

// UserDetails class -> used by spring security to find all of the necessary information for authorization & authentication
public class MyUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private boolean enabled;
	private List<GrantedAuthority> authorities;
	
	
	// when a new object created, will extract only the RELEVANT info from our User object
	public MyUserDetails(BankUser user) {
		
		this.username = user.getFullname();
		this.password = user.getPassword();
		
		// Granted Authority -> permissions/grants a user has access to retrieve or operations to perform
		// GA is given based on the user's roles
//		this.authorities = Arrays.asList( new SimpleGrantedAuthority( user.getRole().name() ) );
	}
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	
	// all methods after here:
	// - DON'T NEED to store this type of info in the user table
	// - store this info if worthwhile for your security 
	// - have all these methods return true manually if not storing the info
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

}
