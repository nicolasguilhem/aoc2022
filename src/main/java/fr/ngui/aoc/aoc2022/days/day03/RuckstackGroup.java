package fr.ngui.aoc.aoc2022.days.day03;

public class RuckstackGroup {

	private Rucksack firstTucksack;
	private Rucksack secondTucksack;
	private Rucksack thirdTucksack;
	
	public RuckstackGroup(Rucksack firstTucksack, Rucksack secondTucksack, Rucksack thirdTucksack) {
		super();
		this.firstTucksack = firstTucksack;
		this.secondTucksack = secondTucksack;
		this.thirdTucksack = thirdTucksack;
	}
	

	private char getItemInAllStacks() {
		for (char charInFirst : firstTucksack.getStackValue().toCharArray()) {
			for (char charInSecond : secondTucksack.getStackValue().toCharArray()) {
				if (charInFirst == charInSecond) {
					for (char charInThird : thirdTucksack.getStackValue().toCharArray()) {
						if (charInFirst == charInThird) {
							return charInFirst;
						}
					}
				}
			}
		}
		return ' ';
	}
	
	public int getValueItemInAllStacks() {
		char item = getItemInAllStacks();
		int value = Character.getNumericValue(item) - 9;
		if (Character.isUpperCase(item) ) {
			value += 26;
		}
		return value;
	}
	
}
