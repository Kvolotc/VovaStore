package store.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.persistence.dto.BikeDTO;
import store.persistence.dto.BrakeDTO;
import store.persistence.dto.mapper.BikeMapper;
import store.persistence.dto.mapper.BrakeMapper;
import store.service.BrakeService;

@RestController
public class BrakeController {
	
	@Autowired
	private BrakeService service;
	
	@RequestMapping(value = "/brakes", method = RequestMethod.GET)
	public List<BrakeDTO> getAllBrakes() {
		
		return BrakeMapper.brakeListToBrakeDTOList(service.findAll());
	}

	@RequestMapping(value = "/getCountPage/brakes", method = RequestMethod.GET)
	public int getCountPageRacingBikes() {
		return service.findCountPages();
	}
	
	@RequestMapping(value = "/brakes/{page}", method = RequestMethod.GET)
	public List<BrakeDTO> getRacingBikes(@PathVariable("page") int page) {
				
		return BrakeMapper.brakeListToBrakeDTOList(service.findProducts(page));
	}
}
