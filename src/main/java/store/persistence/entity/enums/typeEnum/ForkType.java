package store.persistence.entity.enums.typeEnum;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;

import java.util.Map;

public enum ForkType {

	SPRING("Spring"), OIL_SPRING("Oil Spring"), AIR("Air"),  HARD("Hard"), COIL("Colil");

	private ForkType(final String forkType) {
		this.forkType = forkType;
	}

	public String forkType;

	private final static Map<String, ForkType> types = stream(ForkType.values())
			.collect(toMap(fork -> fork.forkType, fork -> fork));

	public static ForkType getEnumByValue(String forkType) {
		return types.get(forkType);
	}

}
