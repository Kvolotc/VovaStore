package store.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import store.persistence.dto.BikeDTO;
import store.persistence.dto.mapper.BikeMapper;
import store.persistence.entity.Bike;
import store.service.BikeService;

@RestController
public class BikeController {

	@Autowired
	private BikeService service;

	@RequestMapping(value = "/bikes", method = RequestMethod.GET)
	public List<BikeDTO> getAllBikes() {

		return BikeMapper.bikeListToBikeDTOList(service.findAll());
	}

	@RequestMapping(value = "/mountainBikes/{page}", method = RequestMethod.GET)
	public List<BikeDTO> getMountainBikes(@PathVariable("page") int page) {

		return BikeMapper.bikeListToBikeDTOList(service.findMountainBikes(page));
	}

	@RequestMapping(value = "/allMountainBikes/{page}", method = RequestMethod.GET)
	public List<BikeDTO> getAllMountainBikes(@PathVariable("page") int page) {

		return BikeMapper.bikeListToBikeDTOList(service.findAllMountainBikes(page));
	}

	@RequestMapping(value = "/racingBikes/{page}", method = RequestMethod.GET)
	public List<BikeDTO> getRacingBikes(@PathVariable("page") int page) {

		return BikeMapper.bikeListToBikeDTOList(service.findRacingBikes(page));
	}

	@RequestMapping(value = "/getCountPage/mountainBikes", method = RequestMethod.GET)
	public int getCountPageMountainBikes() {
		System.out.println("SIZE PAGE === " + service.findCountPageMountainBikes());
		return service.findCountPageMountainBikes();
	}

	@RequestMapping(value = "/getCountPage/allMountainBikes", method = RequestMethod.GET)
	public int getCountPageAllMountainBikes() {
		System.out.println("SIZE PAGE === " + service.findCountPageAllMountainBikes());
		return service.findCountPageAllMountainBikes();
	}

	@RequestMapping(value = "/getCountPage/racingBikes", method = RequestMethod.GET)
	public int getCountPageRacingBikes() {
		System.out.println("SIZE PAGE === " + service.findCountPageRacingBikes());
		return service.findCountPageRacingBikes();
	}

	@RequestMapping(value = "/searchBikes/", method = RequestMethod.GET)
	public List<BikeDTO> getSearchBikes(@RequestParam String word, @RequestParam int min, @RequestParam int max,
			@RequestParam int page) {

		String words[] = word.split(" ");

		if (words.length > 1) {
			return BikeMapper
					.bikeListToBikeDTOList(service.findBySearchBikesWithTwoSearchWords(words[0], words[1], min, max, page));
		} else {
			System.out.println(service.findBySearchBikesWithOneSearchWord(word, min, max, page));
			return BikeMapper.bikeListToBikeDTOList(service.findBySearchBikesWithOneSearchWord(word, min, max, page));
		}

	}

	@RequestMapping(value = "/countSearchBikes/", method = RequestMethod.GET)
	public int getCountSearchBikes(@RequestParam String word, @RequestParam int min, @RequestParam int max) {

		String words[] = word.split(" ");

		if (words.length > 1) {
			return service.findCountBySearchBikesWithTwoSearchWords(words[0], words[1], min, max);
		} else {
			return service.findCountBySearchBikesWithOneSearchWord(word, min, max);
		}

	}
	
	@RequestMapping(value = "/maxPriceBikes", method = RequestMethod.GET)
	public int findMaxPriceAllMountainBikes() {
		return service.findMaxPrice();
	}

}
