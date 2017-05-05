package store.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import store.persistence.dto.TireDTO;
import store.persistence.dto.TireDTO;
import store.persistence.dto.mapper.TireMapper;
import store.persistence.dto.mapper.TireMapper;
import store.service.TireService;



@RestController
public class TireController {
	
//	private static Logger logger = LoggerFactory.getLogger(TireControler.class);
	
	@Autowired
	private TireService service;
	
	
	@RequestMapping(value = "/tires", method = RequestMethod.GET)

	public List<TireDTO> getAllTiries() {
		
		return TireMapper.tireListToTireDTOList(service.findAll());
	}
	
	@RequestMapping(value = "/getCountPage/tires", method = RequestMethod.GET)
	public int getCountPageRacingBikes() {
		return service.findCountPages();
	}
	
	@RequestMapping(value = "/tires/{page}", method = RequestMethod.GET)
	public List<TireDTO> getRacingBikes(@PathVariable("page") int page) {
				
		return TireMapper.tireListToTireDTOList(service.findProducts(page));
	}
	
	@RequestMapping(value = "/searchTires/", method = RequestMethod.GET)
	public List<TireDTO> getSearchBikes(@RequestParam String word, @RequestParam int min, @RequestParam int max,
			@RequestParam int page) {

		String words[] = word.split(" ");

		if (words.length > 1) {
			return TireMapper
					.tireListToTireDTOList(service.findBySearchProductsWithTwoSearchWords(words[0], words[1], min, max, page));
		} else {
			return TireMapper.tireListToTireDTOList(service.findBySearchProductsWithOneSearchWord(words[0], min, max, page));
		}

	}

	@RequestMapping(value = "/countSearchTires/", method = RequestMethod.GET)
	public int getCountSearchBikes(@RequestParam String word, @RequestParam int min, @RequestParam int max) {

		String words[] = word.split(" ");

		if (words.length > 1) {
			return service.findCountBySearchProductsWithTwoSearchWords(words[0], words[1], min, max);
		} else {
			return service.findCountBySearchProductsWithOneSearchWord(word, min, max);
		}

	}
}
