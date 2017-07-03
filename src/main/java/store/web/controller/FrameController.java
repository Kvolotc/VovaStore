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

import store.persistence.dto.FrameDTO;
import store.persistence.dto.FrameDTO;
import store.persistence.dto.mapper.FrameMapper;
import store.persistence.dto.mapper.FrameMapper;
import store.persistence.entity.Bike;
import store.persistence.entity.Frame;
import store.service.FrameService;

@RestController
public class FrameController {

	@Autowired
	private FrameService service;
	
	@RequestMapping(value = "/frames", method = RequestMethod.GET)
	public List<FrameDTO> getAllFrames() {
		
		return FrameMapper.frameListToFrameDTOList(service.findAll());
	}
	
	@RequestMapping(value = "/getAmountPage/frames", method = RequestMethod.GET)
	public int getCountPageRacingBikes() {
		return service.findAmountPages();
	}
	
	@RequestMapping(value = "/frames/{page}", method = RequestMethod.GET)
	public List<FrameDTO> getRacingBikes(@PathVariable("page") int page) {
				
		return FrameMapper.frameListToFrameDTOList(service.findProducts(page));
	}
	
	@RequestMapping(value = "/searchFrames/", method = RequestMethod.GET)
	public List<FrameDTO> getSearchBikes(@RequestParam String word, @RequestParam int min, @RequestParam int max,
			@RequestParam int page) {

		String words[] = word.split(" ");

		if (words.length > 1) {
			return FrameMapper
					.frameListToFrameDTOList(service.findBySearchProductsWithTwoSearchWords(words[0], words[1], min, max, page));
		} else {
			return FrameMapper.frameListToFrameDTOList(service.findBySearchProductsWithOneSearchWord(words[0], min, max, page));
		}

	}

	@RequestMapping(value = "/getAmountPageSearchFrames/", method = RequestMethod.GET)
	public int getCountSearchBikes(@RequestParam String word, @RequestParam int min, @RequestParam int max) {

		String words[] = word.split(" ");

		if (words.length > 1) {
			return service.findAmountBySearchProductsWithTwoSearchWords(words[0], words[1], min, max);
		} else {
			return service.findAmountBySearchProductsWithOneSearchWord(word, min, max);
		}

	}
	
	@RequestMapping(value = "/maxPriceFrames", method = RequestMethod.GET)
	public int findMaxPrice() {
		return service.findMaxPriceProduct();
	}
	
	@RequestMapping(value = "/photo/frame/{frameId}", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public void changePhoto(@RequestBody MultipartFile file, @PathVariable("frameId") int frameId) throws IOException {

		File filee = new File("C:\\VoVaStore\\VovaStore\\Store\\src\\main\\resources\\static\\images\\frames\\"
				+ file.getOriginalFilename());

		file.transferTo(filee);	

		Frame frame = service.findById(frameId);
		frame.setImageName(file.getOriginalFilename());
		service.update(frame);

	}
}
