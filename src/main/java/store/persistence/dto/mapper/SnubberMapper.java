package store.persistence.dto.mapper;

import store.persistence.dto.SnubberDTO;
import store.persistence.entity.Snubber;
import store.persistence.entity.enums.brandEnum.SnuubberBrand;
import store.persistence.entity.enums.typeEnum.SnubberType;

public class SnubberMapper {
	
	public static Snubber SnubberDTOToSnubber(SnubberDTO dto) {
		
		Snubber snubber = new Snubber();
		
		snubber.setBrandSnubber(SnuubberBrand.valueOf(dto.getBrandSnubber()));
		snubber.setCourseSnubber(dto.getCourseSnubber());
		snubber.setTypeSnubber(SnubberType.getEnumByValue(dto.getTypeSnubber()));
		
		return snubber;
	}
	
	public static SnubberDTO SnubberToSnubberDTO(Snubber snubber) {
		
		SnubberDTO dto = new SnubberDTO();
		
		dto.setBrandSnubber(snubber.getBrandSnubber().toString());
		dto.setCourseSnubber(snubber.getCourseSnubber());
		dto.setTypeSnubber(snubber.getTypeSnubber().snubberType);
		
		return dto;
	}

	private SnubberMapper() {

	}
	
	
}
