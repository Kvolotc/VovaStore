package store.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import store.persistence.dto.RimDTO;
import store.persistence.dto.RimDTO;
import store.persistence.dto.mapper.RimMapper;
import store.persistence.dto.mapper.RimMapper;
import store.persistence.entity.Bike;
import store.persistence.entity.Rim;
import store.service.RimService;

@Controller
public class RimController {

	@Autowired
	private RimService service;
	
	@ResponseBody
	@RequestMapping(value = "/rims", method = RequestMethod.GET)
	public List<RimDTO> getAllRims() {
		
		return RimMapper.rimListToRimDTOList(service.findAll());
	}
	
	@ResponseBody
	@RequestMapping(value = "/getAmountPage/rims", method = RequestMethod.GET)
	public int getCountPageRacingBikes() {
		return service.findAmountPages();
	}
	
	@ResponseBody
	@RequestMapping(value = "/rims/{page}", method = RequestMethod.GET)
	public List<RimDTO> getRacingBikes(@PathVariable("page") int page) {
				System.out.println(service.findProducts(page));
				System.out.println(RimMapper.rimListToRimDTOList(service.findProducts(page)));
		return RimMapper.rimListToRimDTOList(service.findProducts(page));
	}
	
	@ResponseBody
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

	@ResponseBody
	@RequestMapping(value = "/getAmountPageSearchRims/", method = RequestMethod.GET)
	public int getCountSearchBikes(@RequestParam String word, @RequestParam int min, @RequestParam int max) {

		String words[] = word.split(" ");

		if (words.length > 1) {
			return service.findAmountBySearchProductsWithTwoSearchWords(words[0], words[1], min, max);
		} else {
			return service.findAmountBySearchProductsWithOneSearchWord(word, min, max);
		}

	}
	
	@ResponseBody
	@RequestMapping(value = "/maxPriceRims", method = RequestMethod.GET)
	public int findMaxPrice() {
		return service.findMaxPriceProduct();
	}
	
	@RequestMapping(value = "/photo/rim/{rimId}", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String changePhoto(@RequestBody MultipartFile file, @PathVariable("rimId") int rimId) throws IOException {

		File filee = new File("C:\\VoVaStore\\VovaStore\\Store\\src\\main\\resources\\static\\images\\rims\\"
				+ file.getOriginalFilename());

		file.transferTo(filee);	

		Rim rim = service.findById(rimId);
		rim.setImageName(file.getOriginalFilename());
		service.update(rim);
		
		return "changeFile";

	}
}
