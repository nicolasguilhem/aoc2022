package fr.ngui.aoc.aoc2022.days.day11;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum OperatorEnum {

	MULTIPLY("*", (value1, value2) -> value1.multiply(value2)),
	ADD("+", (value1, value2) -> value1.add(value2));

	private final String sign;
	private final BinaryOperator<BigInteger> operation;

	private OperatorEnum(String sign, BinaryOperator<BigInteger> operation) {
		this.sign = sign;
		this.operation = operation;
	}
	
	public BigInteger doOperation(BigInteger value1, BigInteger value2) {
		return this.operation.apply(value1, value2);
	}

	public static OperatorEnum fromSign(String code) {
		return Arrays.asList(OperatorEnum.values()).stream()
				.filter(enu -> enu.sign.equals(code))
				.findFirst().orElseThrow();
	}
}
