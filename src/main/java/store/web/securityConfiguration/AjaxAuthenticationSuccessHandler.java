package store.web.securityConfiguration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import store.service.serviceImpl.CustomUserDetailsService;
import store.service.serviceImpl.UserRepositoryUserDetails;


public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private final Logger logger = Logger.getLogger(AjaxAuthenticationSuccessHandler.class);
	
	private AuthenticationSuccessHandler defaultHandler;

	public AjaxAuthenticationSuccessHandler(AuthenticationSuccessHandler defaultHandler) {
		this.defaultHandler = defaultHandler;
	}

	public AuthenticationSuccessHandler getDefaultHandler() {
		return defaultHandler;
	}

	public void setDefaultHandler(AuthenticationSuccessHandler defaultHandler) {
		this.defaultHandler = defaultHandler;
	}
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Authentication authentication) throws IOException, ServletException {

		String state = null;

		UserRepositoryUserDetails principal = (UserRepositoryUserDetails) authentication.getPrincipal();
		logger.info(principal.getClass());

		System.out.println("MY AjaxAuthenticationSuccessHandler ======= "+principal.getUsername());

		}
		

	}
