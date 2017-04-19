package store.persistence.entity.enums.brandEnum;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;

import java.util.Map;


public enum ForkBrand {

	ROCKSHOCK("ROCK SHOCK"),
	FOX("FOX"),
	SR_SUNTOUR("SR SUNTOUR"),
	ALUXX("ALUXX"),
	OVERRDRIVE("OVERRDRIVE"),
	CUBE("CUBE"),
	COMANCHE("COMANCHE"),
	RST("RST"),
	X_FUSION("X-Fusion");
	
	public final String forkBrand;
	
	ForkBrand(final String forkBrand) {
		this.forkBrand = forkBrand;
	}
	
	private final static Map<String, ForkBrand> types = stream(ForkBrand.values())
			.collect(toMap(fork -> fork.forkBrand, fork -> fork));

	public static ForkBrand getEnumByValue(String forkBrand) {
		return types.get(forkBrand);
	}
	
}
