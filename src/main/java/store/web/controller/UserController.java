package store.web.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.persistence.entity.User;
import store.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public HttpStatus showAll(@RequestBody User user) {
		service.save(user);
		return HttpStatus.OK;
	}
	
	
	@RequestMapping(value = "/email", method = RequestMethod.POST)
	public boolean checkIfExistUser(@RequestBody String email) throws IOException {
		
		
		System.out.println("Old email "+email);
		email = email.substring(6).replace("%40", "@");

		System.out.println("New emai "+email);
		
		try {

			service.findByEmail(email);

		} catch (Exception e) {
	
			return true ;  
		}

		return false; 

	}


}
