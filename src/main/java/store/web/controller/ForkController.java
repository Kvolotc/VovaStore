package store.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import store.persistence.dto.ForkDTO;
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

	@RequestMapping(value = "/searchForks/", method = RequestMethod.GET)
	public List<ForkDTO> getSearchBikes(@RequestParam String word, @RequestParam int min, @RequestParam int max,
			@RequestParam int page) {

		String words[] = word.split(" ");

		if (words.length > 1) {
			return ForkMapper
					.forkListToForkDTOList(service.findBySearchProductsWithTwoSearchWords(words[0], words[1], min, max, page));
		} else {
			return ForkMapper.forkListToForkDTOList(service.findBySearchProductsWithOneSearchWord(words[0], min, max, page));
		}

	}

	@RequestMapping(value = "/countSearchForks/", method = RequestMethod.GET)
	public int getCountSearchBikes(@RequestParam String word, @RequestParam int min, @RequestParam int max) {

		String words[] = word.split(" ");

		if (words.length > 1) {
			return service.findCountBySearchProductsWithTwoSearchWords(words[0], words[1], min, max);
		} else {
			return service.findCountBySearchProductsWithOneSearchWord(word, min, max);
		}

	}
	
	@RequestMapping(value = "/maxPriceForks", method = RequestMethod.GET)
	public int findMaxPrice() {
		return service.findMaxPriceProduct();
	}
}
