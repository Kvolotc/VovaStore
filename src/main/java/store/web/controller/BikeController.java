package store.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.persistence.entity.Bike;
import store.service.BikeService;

@RestController
public class BikeController {

	@Autowired
	private BikeService service;

	@RequestMapping(value = "/bikes", method = RequestMethod.GET)
	public List<Bike> showAll() {
		return service.findAll();
	}
}
