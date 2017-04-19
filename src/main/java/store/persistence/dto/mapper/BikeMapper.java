package store.persistence.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import store.persistence.dto.BikeDTO;
import store.persistence.entity.Bike;

public class BikeMapper {
	
	public static Bike bikeDTOToBike(BikeDTO dto) {
		
		Bike bike = new Bike();
		
		bike.setPrice(dto.getPrice());
		bike.setBrake(BrakeMapper.brakeDTOToBrake(dto.getBrake()));
		bike.setFork(ForkMapper.forkDTOToFork(dto.getFork()));
		bike.setFrame(FrameMapper.frameDTOToFrame(dto.getFrame()));
		bike.setRim(RimMapper.rimDTOToRim(dto.getRim()));
		bike.setTire(TireMapper.tireDTOToTire(dto.getTire()));
		bike.setImageName(dto.getImageName());
		
		return bike;
	}
	
	public static BikeDTO bikeToBikeDTO(Bike bike) {
		
		BikeDTO dto = new BikeDTO();
		
		dto.setPrice(bike.getPrice());
		dto.setBrake(BrakeMapper.brakeToBrakeDTO(bike.getBrake()));
		dto.setFork(ForkMapper.forkToForkDTO(bike.getFork()));
		dto.setFrame(FrameMapper.frameToFrameDTO(bike.getFrame()));
		dto.setRim(RimMapper.rimToRimDTO(bike.getRim()));
		dto.setTire(TireMapper.tireToTireDTO(bike.getTire()));
		dto.setImageName(bike.getImageName());
		
		return dto;
	}
	
	public static List<Bike> bikeDTOListToBikelist(List<BikeDTO> dtos) {
		
		return dtos.stream().map(dto -> bikeDTOToBike(dto)).collect(Collectors.toList());
	}
	
	public static List<BikeDTO> bikeListToBikeDTOlist(List<Bike> bikes) {

		return bikes.stream().map(bike -> bikeToBikeDTO(bike)).collect(Collectors.toList());
	}

	private BikeMapper() {
		
	}
	
}
