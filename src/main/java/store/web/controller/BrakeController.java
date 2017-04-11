package store.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.persistence.entity.Bike;
import store.persistence.entity.Brake;
import store.service.BrakeService;

@RestController
public class BrakeController {
	
	@Autowired
	private BrakeService service;
	
	@RequestMapping(value = "/breakes", method = RequestMethod.GET)
	public List<Brake> showAll() {
		return service.findAll();
	}

}
