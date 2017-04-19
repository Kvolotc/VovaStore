package store.persistence.entity.enums.typeEnum;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;

import java.util.Map;

public enum RimType {
	
	SINGLE_WALLED("Single walled"),
	DOUBLE_WALLED("Double walled"),
	TRIPLE_WALLED("Triple walled"),
	SINGLE_WALLED_HIGH("Single walled high");
	
	private RimType(final String rimType) {
		this.rimType = rimType;
	}

	public String rimType;

	private final static Map<String, RimType> types = stream(RimType.values())
			.collect(toMap(rim -> rim.rimType, rim -> rim));

	public static RimType getEnumByValue(String rimType) {
		return types.get(rimType);
	}
	
}
