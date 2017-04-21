package store.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.persistence.dto.BrakeDTO;
import store.persistence.dto.mapper.BrakeMapper;
import store.service.BrakeService;

@RestController
public class BrakeController {
	
	@Autowired
	private BrakeService service;
	
	@RequestMapping(value = "/brakes", method = RequestMethod.GET)
	public List<BrakeDTO> getAllBrakes() {
		
		return BrakeMapper.brakeListToBrakeDTOlist(service.findAll());
	}

}
