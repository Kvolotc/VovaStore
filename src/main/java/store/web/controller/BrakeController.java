package store.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import store.persistence.dto.BrakeDTO;
import store.persistence.dto.mapper.BrakeMapper;
import store.persistence.entity.Brake;
import store.service.BrakeService;

@Controller
public class BrakeController {
	
	@Autowired
	private BrakeService service;
	
	@ResponseBody
	@RequestMapping(value = "/brakes", method = RequestMethod.GET)
	public List<BrakeDTO> getAllBrakes() {
		
		return BrakeMapper.brakeListToBrakeDTOList(service.findAll());
	}

	@ResponseBody
	@RequestMapping(value = "/getAmountPage/brakes", method = RequestMethod.GET)
	public int getCountPageRacingBikes() {
		return service.findAmountPages();
	}
	
	@ResponseBody
	@RequestMapping(value = "/brakes/{page}", method = RequestMethod.GET)
	public List<BrakeDTO> getRacingBikes(@PathVariable("page") int page) {
				
		return BrakeMapper.brakeListToBrakeDTOList(service.findProducts(page));
	}
	
	@ResponseBody
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

	@ResponseBody
	@RequestMapping(value = "/getAmountPageSearchBrakes/", method = RequestMethod.GET)
	public int getCountSearchBikes(@RequestParam String word, @RequestParam int min, @RequestParam int max) {

		String words[] = word.split(" ");

		if (words.length > 1) {
			return service.findAmountBySearchProductsWithTwoSearchWords(words[0], words[1], min, max);
		} else {
			return service.findAmountBySearchProductsWithOneSearchWord(word, min, max);
		}

	}
	
	@ResponseBody
	@RequestMapping(value = "/maxPriceBrakes", method = RequestMethod.GET)
	public int findMaxPrice() {
		return service.findMaxPriceProduct();
	}
	
	@RequestMapping(value = "/photo/brake/{brakeId}", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String changePhoto(@RequestBody MultipartFile file, @PathVariable("brakeId") int brakeId) throws IOException {

		File filee = new File("C:\\VoVaStore\\VovaStore\\Store\\src\\main\\resources\\static\\images\\brakes\\"
				+ file.getOriginalFilename());

		file.transferTo(filee);	

		Brake brake = service.findById(brakeId);
		brake.setImageName(file.getOriginalFilename());
		service.update(brake);
		
		return "changeFile";

	}
}
