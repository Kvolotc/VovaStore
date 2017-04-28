package store.persistence.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import store.persistence.dto.BrakeDTO;
import store.persistence.entity.Brake;
import store.persistence.entity.enums.brandEnum.BrakeBrand;
import store.persistence.entity.enums.typeEnum.BrakeType;

public class BrakeMapper {
	
	public static Brake brakeDTOToBrake(BrakeDTO dto) {
		
		Brake brake = new Brake();
		
		brake.setBrand(BrakeBrand.valueOf(dto.getBrand()));
		brake.setModel(dto.getModel());
		brake.setPrice(dto.getPrice());
		brake.setCreatedOn(dto.getCreatedOn());
		brake.setType(BrakeType.getEnumByValue(dto.getType()));
		brake.setImageName(dto.getImageName());
		
		return brake;
	}
	
	public static BrakeDTO brakeToBrakeDTO(Brake brake) {
		
		BrakeDTO dto = new BrakeDTO();
		
		dto.setImageName(brake.getImageName());
		dto.setCreatedOn(brake.getCreatedOn());;
		dto.setBrand(brake.getBrand().toString());
		dto.setModel(brake.getModel());
		dto.setPrice(brake.getPrice());
		dto.setType(brake.getType().brakeType);
		
		return dto;
	}

	public static List<Brake> brakeDTOListToBrakeList(List<BrakeDTO> dtos) {
		
		return dtos.stream().map(dto -> brakeDTOToBrake(dto)).collect(Collectors.toList());
	}
	
	public static List<BrakeDTO> brakeListToBrakeDTOList(List<Brake> brakes) {
		
		return brakes.stream().map(brake -> brakeToBrakeDTO(brake)).collect(Collectors.toList());
	}
	
	private BrakeMapper() {

	}
	
	
}
