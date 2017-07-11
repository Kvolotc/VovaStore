package store.persistence.entity.enums;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;

import java.util.Map;

public enum Product {
	
	BIKES("bikes"),
	FRAMES("frames"),
	FORKS("forks"),
	BRAKES("brakes"),
	TIRES("tires"),
	RIMS("rims");
	
	private Product(final String typeProduct) {
		this.typeProduct = typeProduct;
	}

	public String typeProduct;

	private final static Map<String, Product> types = stream(Product.values())
			.collect(toMap(product -> product.typeProduct, product -> product));

	public static Product getEnumByValue(String typeProduct) {
		return types.get(typeProduct);
	}

}
