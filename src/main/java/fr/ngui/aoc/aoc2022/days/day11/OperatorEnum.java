package fr.ngui.aoc.aoc2022.days.day11;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.LongUnaryOperator;

public enum OperatorEnum {

	MULTIPLY("*", (value1, value2) -> value1 * value2),
	ADD("+", (value1, value2) -> value1+ value2);

	private final String sign;
	private final BinaryOperator<Long> operation;

	private OperatorEnum(String sign, BinaryOperator<Long> operation) {
		this.sign = sign;
		this.operation = operation;
	}
	
	public Long doOperation(Long value1, Long value2, LongUnaryOperator afterInspection) {
		return afterInspection.applyAsLong(this.operation.apply(value1, value2));
	}

	public static OperatorEnum fromSign(String code) {
		return Arrays.asList(OperatorEnum.values()).stream()
				.filter(enu -> enu.sign.equals(code))
				.findFirst().orElseThrow();
	}
}
