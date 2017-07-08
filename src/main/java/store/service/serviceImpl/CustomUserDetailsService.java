
package store.service.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import store.persistence.entity.User;
import store.persistence.entity.enums.Role;
import store.persistence.repository.UserDao;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private  UserDao repository;

	public CustomUserDetailsService() {}	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("CusmonUserDetail Serviseee !!!!!!!!!!!");
		User user;
		System.out.println(username);
		try {
			user = repository.findByEmail(username);
		} catch (Exception e) {
			user = null;
		}
		if (user == null) {
			throw new UsernameNotFoundException(String.format("User %s does not exist!", username));
		}
		
		user.setLogged(true);
		repository.update(user);
		
		return new UserRepositoryUserDetails(user);
	}

	 static class UserRepositoryUserDetails implements UserDetails {
		 
		private User user;

		private static final long serialVersionUID = 1L;

		private UserRepositoryUserDetails(User user) {
			this.user = user;
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			Collection<Role> roles = new ArrayList<Role>();
			System.out.println("ROLE IS = "+user.getRole());
			roles.add(user.getRole());
			return roles;
		}

		@Override
		public String getUsername() {
			return user.getEmail();
		}

		@Override
		public String getPassword() {
			return user.getPassword();
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
}
