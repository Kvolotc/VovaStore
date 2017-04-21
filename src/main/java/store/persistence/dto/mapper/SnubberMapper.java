package store.persistence.dto.mapper;

import store.persistence.dto.SnubberDTO;
import store.persistence.entity.Snubber;
import store.persistence.entity.enums.brandEnum.ForkBrand;
import store.persistence.entity.enums.typeEnum.ForkType;

public class SnubberMapper {
	
	public static Snubber SnubberDTOToSnubber(SnubberDTO dto) {
		
		Snubber snubber = new Snubber();
		
		snubber.setModelSnubber(dto.getModelSnubber());
		snubber.setBrandSnubber(ForkBrand.getEnumByValue(dto.getBrandSnubber()));
		snubber.setCourseSnubber(dto.getCourseSnubber());
		snubber.setTypeSnubber(ForkType.getEnumByValue(dto.getTypeSnubber()));
		
		return snubber;
	}
	
	public static SnubberDTO SnubberToSnubberDTO(Snubber snubber) {
		
		SnubberDTO dto = new SnubberDTO();
		
		dto.setModelSnubber(snubber.getModelSnubber());
		dto.setBrandSnubber(snubber.getBrandSnubber().forkBrand);
		dto.setBrandSnubber(snubber.getBrandSnubber().toString());
		dto.setCourseSnubber(snubber.getCourseSnubber());
		dto.setTypeSnubber(snubber.getTypeSnubber().forkType);
		
		return dto;
	}

	private SnubberMapper() {
		
	}
	
}
