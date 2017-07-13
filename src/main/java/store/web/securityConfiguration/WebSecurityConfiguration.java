package store.web.securityConfiguration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;


import store.service.serviceImpl.CustomUserDetailsService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
//	  @Override
//	    public void configure(WebSecurity web) throws Exception {
//	        web.ignoring()
//	            .antMatchers(HttpMethod.OPTIONS, "/**")
//	            .antMatchers("/resources/**");
//	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	     http.
	     csrf().disable()
	     .authorizeRequests()
	     .antMatchers("/changeImageBikes/*").hasAuthority("ADMIN")
	     .antMatchers("/changeImageFrames/*").hasAuthority("ADMIN")
	     .antMatchers("/changeImageForks/*").hasAuthority("ADMIN")
	     .antMatchers("/changeImageBrakes/*").hasAuthority("ADMIN")
	     .antMatchers("/changeImageTires/*").hasAuthority("ADMIN")
	     .antMatchers("/changeImageRims/*").hasAuthority("ADMIN")
	     .antMatchers("/registration").anonymous()
	     .antMatchers("/login").anonymous()
	     .antMatchers("/forgotPassword").anonymous()
	     .antMatchers("/users").hasAuthority("ADMIN")
	     .antMatchers("/purchaseProduct").hasAnyAuthority("USER", "ADMIN")
	     .and().exceptionHandling().accessDeniedPage("/403");

	}

	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.authenticationProvider(authenticationProvider);
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
	
	/*@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(authenticationProvider());
	}
		
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
*/
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}
