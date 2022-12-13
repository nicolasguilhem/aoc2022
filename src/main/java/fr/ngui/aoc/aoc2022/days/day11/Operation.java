package fr.ngui.aoc.aoc2022.days.day11;

import java.math.BigInteger;
import java.util.Optional;

public class Operation {

	private OperatorEnum operator;
	private Optional<BigInteger> value;

	public Operation(String operation) {
		String[] splitted = operation.split(" ");
		operator = OperatorEnum.fromSign(splitted[0]);
		if (splitted[1].equals("old")) {
			value = Optional.empty();
		} else {
			value = Optional.of(new BigInteger(splitted[1]));
		}
	}
	
	public Optional<BigInteger> getValue() {
		return value;
	}
	public OperatorEnum getOperator() {
		return operator;
	}
	
	public void setOperator(OperatorEnum operator) {
		this.operator = operator;
	}
	
	public BigInteger doOperation(BigInteger oldValue) {
		return this.operator.doOperation(oldValue, value.orElse(oldValue));
	}

	@Override
	public String toString() {
		return "Operation :" + operator + " " + value;
	}
}
