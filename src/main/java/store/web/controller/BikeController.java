package store.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.persistence.dto.BikeDTO;
import store.persistence.dto.mapper.BikeMapper;
import store.persistence.entity.Bike;
import store.service.BikeService;

@RestController
public class BikeController {

	@Autowired
	private BikeService service;

	@RequestMapping(value = "/bike/all", method = RequestMethod.GET)
	public List<BikeDTO> getAllBikes() {
		
		
		return BikeMapper.bikeListToBikeDTOlist(service.findAll());
	}
	
	@RequestMapping(value = "/bike/mountain", method = RequestMethod.GET)
	public List<BikeDTO> getMountainBikes() {
		
		
		return BikeMapper.bikeListToBikeDTOlist(service.findMountainBikes());
	}
	
	@RequestMapping(value = "/bike/allMountain", method = RequestMethod.GET)
	public List<BikeDTO> getAllMountainBikes() {
		
		
		return BikeMapper.bikeListToBikeDTOlist(service.findAllMountainBikes());
	}
	
	@RequestMapping(value = "/bike/racing", method = RequestMethod.GET)
	public List<BikeDTO> getRacingBikes() {
		
		
		return BikeMapper.bikeListToBikeDTOlist(service.findRacingBikes());
	}
}
