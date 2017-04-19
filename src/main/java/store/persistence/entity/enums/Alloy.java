package store.persistence.entity.enums;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;

import java.util.Map;

public enum Alloy {
	 
	STEEL("Steel"),
	ALUMINUM("Aluminum"),
	CARBON("Carbon");
	
	private Alloy(final String alloyType) {
		this.alloyType = alloyType;
	}

	public String alloyType;

	private final static Map<String, Alloy> types = stream(Alloy.values())
			.collect(toMap(alloy -> alloy.alloyType, alloy -> alloy));

	public static Alloy getEnumByValue(String alloyType) {
		return types.get(alloyType);
	}
}