package store.web.controller;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.descriptor.web.LoginConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import store.persistence.dto.UserDTO;
import store.persistence.dto.mapper.UserMapper;
import store.persistence.entity.User;
import store.persistence.model.ForgotPasswordParam;
import store.persistence.model.LoginParam;
import store.persistence.model.UpdateUserParam;
import store.service.UserService;
import store.service.serviceImpl.CustomUserDetailsService;
import store.service.serviceImpl.UserRepositoryUserDetails;

@Controller
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private AuthenticationManager authenticationManager;

	@RequestMapping(value = "/newUser", method = RequestMethod.POST, produces = MediaType.ALL_VALUE)
	@ResponseBody
	public String registrateUser(@RequestBody User user) {
		user.setRegistrationDate(new Timestamp(System.currentTimeMillis()));
		String token = service.save(user).getPassword();

		return new Gson().toJson(token);
	}

	@RequestMapping(value = "/email", method = RequestMethod.POST)
	@ResponseBody
	public boolean checkIfExistUserWithThisEmail(@RequestBody String email) {

		System.out.println("EMAIL in JAVA = " + email);

		int cutNameValue = 6;
		email = email.substring(cutNameValue).replace("%40", "@");

		try {

			service.findByEmail(email);
			System.out.println(service.findByEmail(email));
			return false;

		} catch (Exception e) {

			return true;
		}

	}

	@RequestMapping(value = "/actived/{token}/**", method = RequestMethod.GET)
	public String findByToken(@PathVariable("token") String token, HttpServletRequest request) {

		String urlTail = new AntPathMatcher().extractPathWithinPattern("/actived/{token}/**", request.getRequestURI());

		if (!urlTail.equals("")) {
			token += "/" + urlTail;
		}

		try {

			User user = service.findByToken(token);
			user.setActivated(true);
			service.update(user);

			return "activate";

		} catch (Exception e) {
			return "404";
		}

	}

	@RequestMapping(value = "/logoutUser", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> logoutUser(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		User user = null;
		if (auth != null) {
			user = service.findByEmail(auth.getName());
			user.setLogged(false);
			service.update(user);
			new SecurityContextLogoutHandler().logout(request, response, auth);
			return new ResponseEntity<>(UserMapper.userToUserDTO(user), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<UserDTO> loginUser(@RequestBody LoginParam loginParam) {

		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		User user = null;
		System.out.println(loginParam.getUsername() + "  " + loginParam.getPassword());

		if (loginParam.getUsername() == null || loginParam.getPassword() == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

		try {
			user = service.findByEmail(loginParam.getUsername());

		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

		if (passwordEncoder.matches(loginParam.getPassword(), user.getPassword()) && user.isActivated() == true) {

			UserRepositoryUserDetails details = new UserRepositoryUserDetails(user);

			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
					details, loginParam.getPassword(), details.getAuthorities());

			authenticationManager.authenticate(usernamePasswordAuthenticationToken);

			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

			user.setLogged(true);
			service.update(user);

			return new ResponseEntity<>(UserMapper.userToUserDTO(user), HttpStatus.OK);
		} else if (passwordEncoder.matches(loginParam.getPassword(), user.getPassword())
				&& user.isActivated() == false) {
			return new ResponseEntity<>(UserMapper.userToUserDTO(user), HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<>(UserMapper.userToUserDTO(user), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/forgotPassword", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<UserDTO> forgotPassword(@RequestBody ForgotPasswordParam forgotPasswordParam) {

		System.out.println(forgotPasswordParam.geteMail() + "  " + forgotPasswordParam.getPassword());

		User user = null;
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		try {

			user = service.findByEmail(forgotPasswordParam.geteMail());

			user.setPassword(passwordEncoder.encode(forgotPasswordParam.getPassword()));
			service.update(user);
			return new ResponseEntity<>(UserMapper.userToUserDTO(user), HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(UserMapper.userToUserDTO(user), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/getCurrentUser", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<UserDTO> getCurrent(@AuthenticationPrincipal Principal user) {

		try {
			return new ResponseEntity<>(UserMapper.userToUserDTO(service.findByEmail(user.getName())), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
	@ResponseBody
	public UserDTO updateUser(@RequestBody UpdateUserParam newUser) {
		User user = service.findByEmail(newUser.getCurrentEmail());

		user.setFirstName(newUser.getFirstName());
		user.setLastName(newUser.getLastName());

		if (!user.getEmail().equals(newUser.getEmail())) {
			user.setEmail(newUser.getEmail());
		}

		service.update(user);

		return UserMapper.userToUserDTO(user);
	}

	@RequestMapping(value = "/users/{page}", method = RequestMethod.GET)
	@ResponseBody
	public List<UserDTO> getUsers(@PathVariable("page") int page) {

		return UserMapper.userListToUserDTOList(service.findUserByPage(page));
	}

	@RequestMapping(value = "/getAmountPageUsers", method = RequestMethod.GET)
	@ResponseBody
	public int findAmountPageUsers() {

		return service.findAmountPageUsers();
	}

}
