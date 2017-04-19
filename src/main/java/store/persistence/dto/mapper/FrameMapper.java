package store.persistence.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import store.persistence.dto.FrameDTO;
import store.persistence.entity.Frame;
import store.persistence.entity.enums.Alloy;
import store.persistence.entity.enums.brandEnum.FrameBrand;
import store.persistence.entity.enums.typeEnum.FrameType;

public class FrameMapper {

	public static Frame frameDTOToFrame(FrameDTO dto) {
		
		Frame frame = new Frame();
		
		frame.setImageName(dto.getImageName());
		frame.setCreatedOn(dto.getCreatedOn());
		frame.setAlloy(Alloy.getEnumByValue(dto.getAlloy()));
		frame.setBrand(FrameBrand.valueOf(dto.getBrand()));
		frame.setExistSnubber(dto.isExistSnubber());
		frame.setModel(dto.getModel());
		frame.setPrice(dto.getPrice());
		frame.setType(FrameType.getEnumByValue(dto.getType()));
		frame.setSnubber(SnubberMapper.SnubberDTOToSnubber(dto.getSnubberDTO()));
		
		return frame;
		
	}
	
	public static FrameDTO frameToFrameDTO(Frame frame) {
		
		FrameDTO dto = new FrameDTO();
		
		dto.setImageName(frame.getImageName());
		dto.setCreatedOn(frame.getCreatedOn());
		dto.setAlloy(frame.getAlloy().toString());
		dto.setBrand(frame.getBrand().toString());
		dto.setExistSnubber(frame.isExistSnubber());
		dto.setModel(frame.getModel());
		dto.setPrice(frame.getPrice());
		dto.setType(frame.getType().frameType);
		dto.setSnubberDTO(SnubberMapper.SnubberToSnubberDTO(frame.getSnubber()));;
		
		return dto;
		
	}
	
	public static List<Frame> frameDTOListToFramelist(List<FrameDTO> dtos) {
		
		return dtos.stream().map(dto -> frameDTOToFrame(dto)).collect(Collectors.toList());
	}
	
	public static List<FrameDTO> frameListToFrameDTOlist(List<Frame> frames) {
		
		return frames.stream().map(frame -> frameToFrameDTO(frame)).collect(Collectors.toList());
	}

	private FrameMapper() {

	}
	
	
}
