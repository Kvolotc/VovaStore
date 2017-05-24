package store.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import store.persistence.dto.RimDTO;
import store.persistence.dto.RimDTO;
import store.persistence.dto.mapper.RimMapper;
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
	
	@RequestMapping(value = "/searchRims/", method = RequestMethod.GET)
	public List<RimDTO> getSearchBikes(@RequestParam String word, @RequestParam int min, @RequestParam int max,
			@RequestParam int page) {

		String words[] = word.split(" ");

		if (words.length > 1) {
			return RimMapper
					.rimListToRimDTOList(service.findBySearchProductsWithTwoSearchWords(words[0], words[1], min, max, page));
		} else {
			return RimMapper.rimListToRimDTOList(service.findBySearchProductsWithOneSearchWord(words[0], min, max, page));
		}

	}

	@RequestMapping(value = "/countSearchRims/", method = RequestMethod.GET)
	public int getCountSearchBikes(@RequestParam String word, @RequestParam int min, @RequestParam int max) {

		String words[] = word.split(" ");

		if (words.length > 1) {
			return service.findCountBySearchProductsWithTwoSearchWords(words[0], words[1], min, max);
		} else {
			return service.findCountBySearchProductsWithOneSearchWord(word, min, max);
		}

	}
	
	@RequestMapping(value = "/maxPriceRims", method = RequestMethod.GET)
	public int findMaxPrice() {
		return service.findMaxPriceProduct();
	}
}
