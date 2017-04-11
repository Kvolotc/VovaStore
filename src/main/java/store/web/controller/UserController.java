package store.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
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

}
