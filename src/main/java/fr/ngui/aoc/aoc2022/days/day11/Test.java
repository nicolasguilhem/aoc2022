package fr.ngui.aoc.aoc2022.days.day11;

import java.math.BigInteger;
import java.util.function.Predicate;

public class Test {

	private final Predicate<BigInteger> condition;
	private int monkeyToThrowIfTrue;
	private int monkeyToThrowIfFalse;

	public Test(String value) {
		this.condition = valueToTest -> valueToTest.mod(BigInteger.valueOf(Integer.parseInt(value))).equals(BigInteger.ZERO);
	}

	public void setMonkeyToThrowIfTrue(String monkeyToThrowIfTrue) {
		this.monkeyToThrowIfTrue = Integer.parseInt(monkeyToThrowIfTrue);
	}

	public void setMonkeyToThrowIfFalse(String monkeyToThrowIfFalse) {
		this.monkeyToThrowIfFalse = Integer.parseInt(monkeyToThrowIfFalse);
	}

	private boolean isMonkeyBoredForItem(BigInteger itemValue) {
		return condition.test(itemValue);
	}

	public int getMonkeyToThrow(BigInteger itemValue) {
		return this.isMonkeyBoredForItem(itemValue) ? monkeyToThrowIfTrue : monkeyToThrowIfFalse;
	}

	@Override
	public String toString() {
		return "Test [true --> " + monkeyToThrowIfTrue + ", false --> " + monkeyToThrowIfFalse + "]";
	}
}
