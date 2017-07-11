package store.service.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import store.persistence.entity.User;
import store.persistence.entity.enums.Role;

public class UserRepositoryUserDetails implements UserDetails {
	 
	private User user;

	private static final long serialVersionUID = 1L;

	public UserRepositoryUserDetails(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<Role> roles = new ArrayList<Role>();
		System.out.println("ROLE IS = "+user.getRole());
		roles.add(user.getRole());
		return roles;
	}


	public String getUsername() {
		return user.getEmail();
	}

	public String getPassword() {
		return user.getPassword();
	}
	
	public boolean getIsActived() {
		return user.isActivated();
	}
	
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
		return true;
	}
}
