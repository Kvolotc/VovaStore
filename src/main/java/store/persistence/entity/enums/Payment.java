package store.persistence.entity.enums;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;

import java.util.Map;

public enum Payment {
	
	CASH("cash"),
	CREDIT("credit");
	
	private Payment(final String typePayment) {
		this.typePayment = typePayment;
	}

	public String typePayment;

	private final static Map<String, Payment> types = stream(Payment.values())
			.collect(toMap(payment -> payment.typePayment, payment -> payment));

	public static Payment getEnumByValue(String payment) {
		return types.get(payment);
	}

}
