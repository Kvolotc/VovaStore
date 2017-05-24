package store.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value = "/searchBrakes/", method = RequestMethod.GET)
	public List<BrakeDTO> getSearchBikes(@RequestParam String word, @RequestParam int min, @RequestParam int max,
			@RequestParam int page) {

		String words[] = word.split(" ");

		if (words.length > 1) {
			return BrakeMapper
					.brakeListToBrakeDTOList(service.findBySearchProductsWithTwoSearchWords(words[0], words[1], min, max, page));
		} else {
			return BrakeMapper.brakeListToBrakeDTOList(service.findBySearchProductsWithOneSearchWord(words[0], min, max, page));
		}

	}

	@RequestMapping(value = "/countSearchBrakes/", method = RequestMethod.GET)
	public int getCountSearchBikes(@RequestParam String word, @RequestParam int min, @RequestParam int max) {

		System.out.println(word);
		System.out.println(min);
		System.out.println(max);
		
		String words[] = word.split(" ");

		if (words.length > 1) {
			return service.findCountBySearchProductsWithTwoSearchWords(words[0], words[1], min, max);
		} else {
			return service.findCountBySearchProductsWithOneSearchWord(word, min, max);
		}

	}
	
	@RequestMapping(value = "/maxPriceBrakes", method = RequestMethod.GET)
	public int findMaxPrice() {
		return service.findMaxPriceProduct();
	}
}
