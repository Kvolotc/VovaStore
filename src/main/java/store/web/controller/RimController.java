package store.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.persistence.dto.RimDTO;
import store.persistence.dto.mapper.RimMapper;
import store.persistence.entity.Bike;
import store.persistence.entity.Rim;
import store.service.RimService;

@RestController
public class RimController {

	@Autowired
	private RimService service;
	
	@RequestMapping(value = "/rims", method = RequestMethod.GET)
	public List<RimDTO> getAllRims() {
		
		return RimMapper.rimListToRimDTOlist(service.findAll());
	}
}
