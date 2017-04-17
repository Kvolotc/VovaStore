package store.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Bike>> getAllBikes() {
		
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}
}
