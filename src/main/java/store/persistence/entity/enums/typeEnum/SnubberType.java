//package store.persistence.entity.enums.typeEnum;
//
//import static java.util.Arrays.stream;
//import static java.util.stream.Collectors.toMap;
//
//import java.util.Map;
//
//public enum SnubberType {
//
//	AIR("Air"),
//	SPRING("Spring");
//	
//	private SnubberType(final String snubberType) {
//		this.snubberType = snubberType;
//	}
//
//	public String snubberType;
//
//	private final static Map<String, SnubberType> types = stream(SnubberType.values())
//			.collect(toMap(snubber -> snubber.snubberType, snubber -> snubber));
//
//	public static SnubberType getEnumByValue(String snubberType) {
//		return types.get(snubberType);
//	}
//}
