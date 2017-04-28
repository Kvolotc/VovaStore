package store.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.persistence.dto.BrakeDTO;
import store.persistence.dto.FrameDTO;
import store.persistence.dto.mapper.BrakeMapper;
import store.persistence.dto.mapper.FrameMapper;
import store.persistence.entity.Bike;
import store.persistence.entity.Frame;
import store.service.FrameService;

@RestController
public class FrameController {

	@Autowired
	private FrameService service;
	
	@RequestMapping(value = "/frames", method = RequestMethod.GET)
	public List<FrameDTO> getAllFrames() {
		
		return FrameMapper.frameListToFrameDTOList(service.findAll());
	}
	
	@RequestMapping(value = "/getCountPage/frames", method = RequestMethod.GET)
	public int getCountPageRacingBikes() {
		return service.findCountPages();
	}
	
	@RequestMapping(value = "/frames/{page}", method = RequestMethod.GET)
	public List<FrameDTO> getRacingBikes(@PathVariable("page") int page) {
				
		return FrameMapper.frameListToFrameDTOList(service.findProducts(page));
	}
}
