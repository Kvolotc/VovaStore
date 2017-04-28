package store.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.persistence.dto.BrakeDTO;
import store.persistence.dto.TireDTO;
import store.persistence.dto.mapper.BrakeMapper;
import store.persistence.dto.mapper.TireMapper;
import store.service.TireService;



@RestController
public class TireController {
	
//	private static Logger logger = LoggerFactory.getLogger(TireControler.class);
	
	@Autowired
	private TireService service;
	
	
	@RequestMapping(value = "/tires", method = RequestMethod.GET)

	public List<TireDTO> getAllTiries() {
		
		return TireMapper.tireListTotireDTOList(service.findAll());
	}
	
	@RequestMapping(value = "/getCountPage/tires", method = RequestMethod.GET)
	public int getCountPageRacingBikes() {
		return service.findCountPages();
	}
	
	@RequestMapping(value = "/tires/{page}", method = RequestMethod.GET)
	public List<TireDTO> getRacingBikes(@PathVariable("page") int page) {
				
		return TireMapper.tireListTotireDTOList(service.findProducts(page));
	}
}
