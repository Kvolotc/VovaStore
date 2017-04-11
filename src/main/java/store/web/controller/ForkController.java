package store.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import store.persistence.entity.Fork;
import store.service.ForkService;

@RestController
public class ForkController {
	
	@Autowired
	private ForkService service;
	
	@RequestMapping(value = "/forks", method = RequestMethod.GET)
	public List<Fork> showAll() {
		return service.findAll();
	}

}
