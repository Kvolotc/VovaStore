package store.persistence.entity.enums.typeEnum;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;

import java.util.Map;

public enum FrameType {

	MOUNTAIN("Mountain"), ALL_MOUNTAIN("All mountain"), RACING("Racing");

	private FrameType(final String frameType) {
		this.frameType = frameType;
	}

	public String frameType;

	private final static Map<String, FrameType> types = stream(FrameType.values())
			.collect(toMap(frame -> frame.frameType, frame -> frame));

	public static FrameType getEnumByValue(String frameType) {
		return types.get(frameType);
	}

}
