package store.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.persistence.dto.BrakeDTO;
import store.persistence.dto.RimDTO;
import store.persistence.dto.mapper.BrakeMapper;
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
		
		return RimMapper.rimListToRimDTOList(service.findAll());
	}
	
	@RequestMapping(value = "/getCountPage/rims", method = RequestMethod.GET)
	public int getCountPageRacingBikes() {
		return service.findCountPages();
	}
	
	@RequestMapping(value = "/rims/{page}", method = RequestMethod.GET)
	public List<RimDTO> getRacingBikes(@PathVariable("page") int page) {
				
		return RimMapper.rimListToRimDTOList(service.findProducts(page));
	}
}
