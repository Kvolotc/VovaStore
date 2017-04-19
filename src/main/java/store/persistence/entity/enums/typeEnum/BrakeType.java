package store.persistence.entity.enums.typeEnum;


import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;

import java.util.Map;

public enum BrakeType {
	
	HYDRAULICS("Hydraulics"), MECHANICAL("Mechanical"), CLOVER("Clover"), RIM("RIM");

	private BrakeType(final String brakeType) {
		this.brakeType = brakeType;
	}

	public String brakeType;

	private final static Map<String, BrakeType> types = stream(BrakeType.values())
			.collect(toMap(brake -> brake.brakeType, brake -> brake));

	public static BrakeType getEnumByValue(String brakeType) {
		return types.get(brakeType);
	}
}
