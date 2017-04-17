package store.web.controller;


import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

import store.persistence.entity.User;
import store.persistence.model.ForgotPasswordParam;
import store.persistence.model.LoginParam;
import store.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;

	@RequestMapping(value = "/newUser", method = RequestMethod.POST, produces = MediaType.ALL_VALUE)
	@ResponseBody
	public ResponseEntity<String> registrateUser(@RequestBody User user) {
		
		user.setRegistered(true);
		String token = service.save(user).getPassword();

		return new ResponseEntity<String>(new Gson().toJson(token), HttpStatus.OK);
	}

	@RequestMapping(value = "/email", method = RequestMethod.POST)
	@ResponseBody
	public boolean checkIfExistUser(@RequestBody String email) throws IOException {
			
		System.out.println("Old email "+email);
		
		int cutNameValue = 6;
		
		email = email.substring(cutNameValue).replace("%40", "@");

		System.out.println("New emai "+email);
		
		try {

			service.findByEmail(email);

		} catch (Exception e) {
	
			return true ;  
		}

		return false; 

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
	
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<User> loginUser(@RequestBody LoginParam loginParam) {
		
		System.out.println(loginParam.geteMail()+"  "+loginParam.getPassword());
		
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		User user = null;
		
		try {
			
			user = service.findByEmail(loginParam.geteMail());
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(user,HttpStatus.BAD_REQUEST);
		}
		
	 	if(passwordEncoder.matches(loginParam.getPassword(), user.getPassword()) && user.isActivated() == true) {
			user.setLogged(true);
			service.update(user);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		else if(passwordEncoder.matches(loginParam.getPassword(), user.getPassword()) && user.isActivated() == false){
			return new ResponseEntity<>(user, HttpStatus.CONFLICT);
		}
		else {
			return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@RequestMapping(value = "/userForgotPassword", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<User> forgotPassword(@RequestBody ForgotPasswordParam forgotPasswordParam) {
		
		System.out.println(forgotPasswordParam.geteMail()+"  "+forgotPasswordParam.getPassword());
		
		User user = null;
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		try {
			
			user = service.findByEmail(forgotPasswordParam.geteMail());
			
			user.setPassword(passwordEncoder.encode(forgotPasswordParam.getPassword()));
			service.update(user);
			return new ResponseEntity<>(user, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(user,HttpStatus.BAD_REQUEST);
		}
	}
}
