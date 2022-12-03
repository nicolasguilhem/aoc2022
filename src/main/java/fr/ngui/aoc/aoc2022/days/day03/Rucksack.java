package fr.ngui.aoc.aoc2022.days.day03;

public class Rucksack {

	private final String firstCompartment;
	private final String secondCompartment;
	
	public Rucksack(String line) {
		super();
		this.firstCompartment = line.substring(0, line.length() /2);
		this.secondCompartment = line.substring(line.length() /2);
	}

	@Override
	public String toString() {
		return String.format("[%s] - [%s] -> %s = %s", firstCompartment, secondCompartment, getItemInBothCompartment(), getValueItemInBothCompartment());
	}
	
	private char getItemInBothCompartment() {
		for (char charInFirst : firstCompartment.toCharArray()) {
			for (char charInSecond : secondCompartment.toCharArray()) {
				if (charInFirst == charInSecond) {
					return charInFirst;
				}
			}
		}
		return ' ';
	}
	
	public int getValueItemInBothCompartment() {
		char item = getItemInBothCompartment();
		int value = Character.getNumericValue(item) - 9;
		if (Character.isUpperCase(item) ) {
			value += 26;
		}
		return value;
	}
	
	public String getStackValue() {
		return firstCompartment + secondCompartment;
	}
}
