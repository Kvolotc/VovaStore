package store.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import store.persistence.entity.Tire;
import store.service.TireService;



@Controller
public class TireController {
	
//	private static Logger logger = LoggerFactory.getLogger(TireControler.class);
	
	@Autowired
	private TireService tireService;
	
	@RequestMapping(value = "/create") 
	@ResponseBody
	public String createTire(@RequestParam String brand, @RequestParam Double price,
			@RequestParam String type, @RequestParam Integer diameter, @RequestParam Double width) {
		
		Tire tire = new Tire();
		tire.setBrand(brand);
		tire.setDiameter(diameter);
		tire.setPrice(price);
		tire.setType(type);
		tire.setWidth(width);
		
		tireService.save(tire);
		return "index";
		
	}
	
	@RequestMapping(value = "/tires", method = RequestMethod.GET)
	@ResponseBody
	public List<Tire> showAll() {
		
		List<Tire> tiries= tireService.findAll();
		System.out.println(tiries.get(2).getBikes());
		return tiries;
	}
	

	@GetMapping("/first")
	@ResponseBody
	public Tire showFirst() {
		return tireService.findById(1);
	}

}
