package fr.ngui.aoc.aoc2022.days.day11;

import java.util.function.Predicate;

public class Test {

	private final Predicate<Long> condition;
	private int monkeyToThrowIfTrue;
	private int monkeyToThrowIfFalse;
	private final int value;

	public Test(String value) {
		this.value = Integer.parseInt(value);
		this.condition = valueToTest -> valueToTest % this.value == 0;
	}

	public int getValue() {
		return value;
	}

	public void setMonkeyToThrowIfTrue(String monkeyToThrowIfTrue) {
		this.monkeyToThrowIfTrue = Integer.parseInt(monkeyToThrowIfTrue);
	}

	public void setMonkeyToThrowIfFalse(String monkeyToThrowIfFalse) {
		this.monkeyToThrowIfFalse = Integer.parseInt(monkeyToThrowIfFalse);
	}

	private boolean isMonkeyBoredForItem(Long itemValue) {
		return condition.test(itemValue);
	}

	public int getMonkeyToThrow(Long itemValue) {
		return this.isMonkeyBoredForItem(itemValue) ? monkeyToThrowIfTrue : monkeyToThrowIfFalse;
	}

	@Override
	public String toString() {
		return "Test [true --> " + monkeyToThrowIfTrue + ", false --> " + monkeyToThrowIfFalse + "]";
	}
}
