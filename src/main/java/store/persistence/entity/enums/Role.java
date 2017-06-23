package store.persistence.entity.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

	ADMIN("ADMIN"),
	USER("USER");
	
	private Role(final String role) {
		this.role = role;
	}

	public String role;

	@Override
	public String getAuthority() {
		return role;
	}
}
