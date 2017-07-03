package store.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	
	@RequestMapping(value = "/getAmountPage/forks", method = RequestMethod.GET)
	public int getCountPageRacingBikes() {
		return service.findAmountPages();
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

	@RequestMapping(value = "/getAmountPageSearchForks/", method = RequestMethod.GET)
	public int getCountSearchBikes(@RequestParam String word, @RequestParam int min, @RequestParam int max) {

		String words[] = word.split(" ");

		if (words.length > 1) {
			return service.findAmountBySearchProductsWithTwoSearchWords(words[0], words[1], min, max);
		} else {
			return service.findAmountBySearchProductsWithOneSearchWord(word, min, max);
		}

	}
	
	@RequestMapping(value = "/maxPriceForks", method = RequestMethod.GET)
	public int findMaxPrice() {
		return service.findMaxPriceProduct();
	}
	
	@RequestMapping(value = "/photo/fork/{forkId}", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public void changePhoto(@RequestBody MultipartFile file, @PathVariable("forkId") int forkId) throws IOException {

		File filee = new File("C:\\VoVaStore\\VovaStore\\Store\\src\\main\\resources\\static\\images\\forks\\"
				+ file.getOriginalFilename());

		file.transferTo(filee);	

		Fork fork = service.findById(forkId);
		fork.setImageName(file.getOriginalFilename());
		service.update(fork);

	}
}
