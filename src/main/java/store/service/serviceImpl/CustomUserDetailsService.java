
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
		User user;
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
}
