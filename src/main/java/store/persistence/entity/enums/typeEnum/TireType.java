package store.persistence.entity.enums.typeEnum;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;

import java.util.Map;

public enum TireType {
	
	RACING("Racing"),
	MOUNTAIN("Mountain");
	
	private TireType(final String tireType) {
		this.tireType = tireType;
	}

	public String tireType;

	private final static Map<String, TireType> types = stream(TireType.values())
			.collect(toMap(tire -> tire.tireType, tire -> tire));

	public static TireType getEnumByValue(String tireType) {
		return types.get(tireType);
	}
	

}
