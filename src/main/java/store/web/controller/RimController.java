package store.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.persistence.entity.Bike;
import store.persistence.entity.Rim;
import store.service.RimService;

@RestController
public class RimController {

	@Autowired
	private RimService service;
	
	@RequestMapping(value = "/rims", method = RequestMethod.GET)
	public List<Rim> showAll() {
		return service.findAll();
	}
}
