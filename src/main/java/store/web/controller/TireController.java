package store.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import store.persistence.dto.TireDTO;
import store.persistence.dto.mapper.TireMapper;
import store.persistence.entity.Tire;
import store.service.TireService;



@Controller
public class TireController {
	
//	private static Logger logger = LoggerFactory.getLogger(TireControler.class);
	
	@Autowired
	private TireService service;
	
	@ResponseBody
	@RequestMapping(value = "/tires", method = RequestMethod.GET)

	public List<TireDTO> getAllTiries() {
		
		return TireMapper.tireListToTireDTOList(service.findAll());
	}
	
	@ResponseBody
	@RequestMapping(value = "/getAmountPage/tires", method = RequestMethod.GET)
	public int getCountPageRacingBikes() {
		return service.findAmountPages();
	}
	
	@ResponseBody
	@RequestMapping(value = "/tires/{page}", method = RequestMethod.GET)
	public List<TireDTO> getRacingBikes(@PathVariable("page") int page) {
				
		return TireMapper.tireListToTireDTOList(service.findProducts(page));
	}
	
	@ResponseBody
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

	@ResponseBody
	@RequestMapping(value = "/getAmountPageSearchTires/", method = RequestMethod.GET)
	public int getCountSearchBikes(@RequestParam String word, @RequestParam int min, @RequestParam int max) {

		String words[] = word.split(" ");

		if (words.length > 1) {
			return service.findAmountBySearchProductsWithTwoSearchWords(words[0], words[1], min, max);
		} else {
			return service.findAmountBySearchProductsWithOneSearchWord(word, min, max);
		}

	}
	
	@ResponseBody
	@RequestMapping(value = "/maxPriceTires", method = RequestMethod.GET)
	public int findMaxPrice() {
		return service.findMaxPriceProduct();
	}
	
	@RequestMapping(value = "/photo/tire/{tireId}", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String changePhoto(@RequestBody MultipartFile file, @PathVariable("tireId") int tireId) throws IOException {

		File filee = new File("C:\\VoVaStore\\VovaStore\\Store\\src\\main\\resources\\static\\images\\tires\\"
				+ file.getOriginalFilename());

		file.transferTo(filee);	

		Tire tire = service.findById(tireId);
		tire.setImageName(file.getOriginalFilename());
		service.update(tire);

		return "changeFile";
	}
}
