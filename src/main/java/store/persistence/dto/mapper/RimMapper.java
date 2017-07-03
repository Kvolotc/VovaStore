package store.persistence.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import store.persistence.dto.RimDTO;
import store.persistence.entity.Rim;
import store.persistence.entity.enums.brandEnum.RimBrand;
import store.persistence.entity.enums.typeEnum.RimType;

public class RimMapper {

	public static Rim rimDTOToRim(RimDTO dto) {
		
		Rim rim = new Rim();
		
		rim.setId(dto.getId());
		rim.setImageName(dto.getImageName());
		rim.setCreatedOn(dto.getCreatedOn());
		rim.setBrand(RimBrand.valueOf(dto.getBrand()));
		rim.setDiameter(dto.getDiameter());
		rim.setModel(dto.getModel());
		rim.setPrice(dto.getPrice());
		rim.setType(RimType.getEnumByValue(dto.getType()));
		
		return rim;
	}
	
	public static RimDTO rimToRimDTO(Rim rim) {
		
		RimDTO dto = new RimDTO();
		
		dto.setId(rim.getId());
		dto.setImageName(rim.getImageName());
		dto.setCreatedOn(rim.getCreatedOn());
		dto.setBrand(rim.getBrand().toString());
		dto.setDiameter(rim.getDiameter());
		dto.setModel(rim.getModel());
		dto.setPrice(rim.getPrice());
		dto.setType(rim.getType().rimType);
		
		return dto;
	}
	
	public static List<Rim> rimDTOListToRimList(List<RimDTO> dtos) {
		
		return dtos.stream().map(dto -> rimDTOToRim(dto)).collect(Collectors.toList());
	}
	
	public static List<RimDTO> rimListToRimDTOList(List<Rim> rims) {
		
		return rims.stream().map(rim -> rimToRimDTO(rim)).collect(Collectors.toList());
	}

	private RimMapper() {

	}
	
	
}
