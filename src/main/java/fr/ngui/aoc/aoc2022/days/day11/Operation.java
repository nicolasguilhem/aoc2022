package fr.ngui.aoc.aoc2022.days.day11;

import java.util.Optional;
import java.util.function.LongUnaryOperator;

public class Operation {

	private OperatorEnum operator;
	private Optional<Long> value;

	public Operation(String operation) {
		String[] splitted = operation.split(" ");
		operator = OperatorEnum.fromSign(splitted[0]);
		if (splitted[1].equals("old")) {
			value = Optional.empty();
		} else {
			value = Optional.of(Long.parseLong(splitted[1]));
		}
	}
	
	public void setOperator(OperatorEnum operator) {
		this.operator = operator;
	}
	
	public Long doOperation(Long oldValue, LongUnaryOperator afterInspection) {
		return this.operator.doOperation(oldValue, value.orElse(oldValue), afterInspection);
	}
}
