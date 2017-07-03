package store.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerMapping;

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

	@RequestMapping(value = "/getAmountPage/mountainBikes", method = RequestMethod.GET)
	public int getAmountPageMountainBikes() {
		System.out.println("SIZE PAGE === " + service.findAmountPageMountainBikes());
		return service.findAmountPageMountainBikes();
	}

	@RequestMapping(value = "/getAmountPage/allMountainBikes", method = RequestMethod.GET)
	public int getAmountPageAllMountainBikes() {
		System.out.println("SIZE PAGE === " + service.findAmountPageAllMountainBikes());
		return service.findAmountPageAllMountainBikes();
	}

	@RequestMapping(value = "/getAmountPage/racingBikes", method = RequestMethod.GET)
	public int getAmountPageRacingBikes() {
		System.out.println("SIZE PAGE === " + service.findAmountPageRacingBikes());
		return service.findAmountPageRacingBikes();
	}

	@RequestMapping(value = "/searchBikes/", method = RequestMethod.GET)
	public List<BikeDTO> getSearchBikes(@RequestParam String word, @RequestParam int min, @RequestParam int max,
			@RequestParam int page) {

		String words[] = word.split(" ");

		if (words.length > 1) {
			return BikeMapper.bikeListToBikeDTOList(
					service.findBySearchBikesWithTwoSearchWords(words[0], words[1], min, max, page));
		} else {
			System.out.println(service.findBySearchBikesWithOneSearchWord(word, min, max, page));
			return BikeMapper.bikeListToBikeDTOList(service.findBySearchBikesWithOneSearchWord(word, min, max, page));
		}

	}

	@RequestMapping(value = "/getAmountPageSearchBikes/", method = RequestMethod.GET)
	public int getAmountSearchBikes(@RequestParam String word, @RequestParam int min, @RequestParam int max) {

		String words[] = word.split(" ");

		if (words.length > 1) {
			return service.findAmountBySearchBikesWithTwoSearchWords(words[0], words[1], min, max);
		} else {
			return service.findAmountBySearchBikesWithOneSearchWord(word, min, max);
		}

	}

	@RequestMapping(value = "/maxPriceBikes", method = RequestMethod.GET)
	public int findMaxPriceAllMountainBikes() {
		return service.findMaxPrice();
	}

	@RequestMapping(value = "/photo/bike/{bikeId}", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public void changePhoto(@RequestBody MultipartFile file, @PathVariable("bikeId") int bikeId) throws IOException {

		File filee = new File("C:\\VoVaStore\\VovaStore\\Store\\src\\main\\resources\\static\\images\\bikes\\"
				+ file.getOriginalFilename());

		file.transferTo(filee);
		
		Bike bike = service.findById(bikeId);
		bike.setImageName(file.getOriginalFilename());
		service.update(bike);

	}

}
