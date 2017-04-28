package store.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.persistence.dto.BrakeDTO;
import store.persistence.dto.ForkDTO;
import store.persistence.dto.mapper.BrakeMapper;
import store.persistence.dto.mapper.ForkMapper;
import store.persistence.entity.Fork;
import store.service.ForkService;

@RestController
public class ForkController {
	
	@Autowired
	private ForkService service;
	
	@RequestMapping(value = "/forks", method = RequestMethod.GET)
	public List<ForkDTO> getllForks() {
		return ForkMapper.forkListToForkDTOList(service.findAll());
	}
	
	@RequestMapping(value = "/getCountPage/forks", method = RequestMethod.GET)
	public int getCountPageRacingBikes() {
		return service.findCountPages();
	}
	
	@RequestMapping(value = "/forks/{page}", method = RequestMethod.GET)
	public List<ForkDTO> getRacingBikes(@PathVariable("page") int page) {
		return ForkMapper.forkListToForkDTOList(service.findProducts(page));
	}

}
