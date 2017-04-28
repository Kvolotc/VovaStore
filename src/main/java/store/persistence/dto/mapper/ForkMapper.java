package store.persistence.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import store.persistence.dto.ForkDTO;
import store.persistence.entity.Fork;
import store.persistence.entity.enums.brandEnum.ForkBrand;
import store.persistence.entity.enums.typeEnum.ForkType;

public class ForkMapper {
	
	public static Fork forkDTOToFork(ForkDTO dto) {
		Fork fork = new Fork();
		
		fork.setImageName(dto.getImageName());
		fork.setCreatedOn(dto.getCreatedOn());;
		fork.setBrand(ForkBrand.getEnumByValue(dto.getBrand()));
		fork.setCourse(dto.getCourse());
		fork.setModel(dto.getModel());
		fork.setPrice(dto.getPrice());
		fork.setType(ForkType.getEnumByValue(dto.getType()));
		
		return fork;
	}
	
	public static ForkDTO forkToForkDTO(Fork fork) {
		ForkDTO dto = new ForkDTO();
		
		dto.setImageName(fork.getImageName());
		dto.setCreatedOn(fork.getCreatedOn());
		dto.setBrand(fork.getBrand().forkBrand);
		dto.setCourse(fork.getCourse());
		dto.setModel(fork.getModel());
		dto.setPrice(fork.getPrice());
		dto.setType(fork.getType().forkType);
		
		return dto;
	}
	
	public static List<Fork> forkDTOListToForkList(List<ForkDTO> dtos) {
		
		return dtos.stream().map(dto -> forkDTOToFork(dto)).collect(Collectors.toList());
	}
	
	public static List<ForkDTO> forkListToForkDTOList(List<Fork> forks) {
		
		return forks.stream().map(fork -> forkToForkDTO(fork)).collect(Collectors.toList());
	}

	private ForkMapper() {

	}
	
}
