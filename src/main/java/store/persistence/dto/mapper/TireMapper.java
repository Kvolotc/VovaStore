package store.persistence.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import store.persistence.dto.TireDTO;
import store.persistence.entity.Tire;
import store.persistence.entity.enums.brandEnum.TireBrand;
import store.persistence.entity.enums.typeEnum.TireType;

public class TireMapper {
	
	public static Tire tireDTOToTire (TireDTO dto) {
		
		Tire tire = new Tire();
		
		tire.setImageName(dto.getImageName());
		tire.setCreatedOn(dto.getCreatedOn());
		tire.setBrand(TireBrand.valueOf(dto.getBrand()));
		tire.setDiameter(dto.getDiameter());
		tire.setModel(dto.getModel());
		tire.setPrice(dto.getPrice());
		tire.setType(TireType.getEnumByValue(dto.getType()));
		tire.setWidth(dto.getWidth());
		
		return tire;
	}
	
	public static TireDTO tireToTireDTO (Tire tire) {
		
		TireDTO dto = new TireDTO();
		
		dto.setImageName(tire.getImageName());
		dto.setCreatedOn(tire.getCreatedOn());
		dto.setBrand(tire.getBrand().toString());
		dto.setDiameter(tire.getDiameter());
		dto.setModel(tire.getModel());
		dto.setPrice(tire.getPrice());
		dto.setType(tire.getType().tireType);
		dto.setWidth(tire.getWidth());
		
		return dto;
	}
	
	public static List<Tire> tireDTOListTotirelist(List<TireDTO> dtos) {
		
		return dtos.stream().map(dto -> tireDTOToTire(dto)).collect(Collectors.toList());
	}
	
	public static List<TireDTO> tireListTotireDTOlist(List<Tire> tires) {
		
		return tires.stream().map(tire -> tireToTireDTO(tire)).collect(Collectors.toList());
	}

	private TireMapper() {

	}
	
}
