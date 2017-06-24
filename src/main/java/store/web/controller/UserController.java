package store.web.controller;

import java.io.IOException;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
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

@Controller
public class UserController {

	@Autowired
	private UserService service;

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

		
		System.out.println("EMAIL in JAVA = "+email);
			
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

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<UserDTO> loginUser(@RequestBody LoginParam loginParam) {

		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		User user = null;
		
		if (loginParam.geteMail() == null || loginParam.getPassword() == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

		try {

			user = service.findByEmail(loginParam.geteMail());

		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

		if (passwordEncoder.matches(loginParam.getPassword(), user.getPassword()) && user.isActivated() == true) {
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
		System.out.println("Hello");
		System.out.println(user);
		
//		UserDTO user2 = new UserDTO();
//		user2.setLogged(true);
//		user2.setRole("ADMIN");
//		return new ResponseEntity<>(user2, HttpStatus.OK) ;
		if(user == null) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(UserMapper.userToUserDTO(service.findByEmail(user.getName())),HttpStatus.OK);
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
	@ResponseBody
	public UserDTO updateUser(@RequestBody UpdateUserParam newUser) {
		User user = service.findByEmail(newUser.getCurrentEmail());
		
		user.setFirstName(newUser.getFirstName());
		user.setLastName(newUser.getLastName());
		
		if(!user.getEmail().equals(newUser.getEmail())) {
			user.setEmail(newUser.getEmail());
		}
		
		service.update(user);
		
		return UserMapper.userToUserDTO(user);
	}
	
}
