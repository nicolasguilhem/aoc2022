package fr.ngui.aoc.aoc2022.days.day02;

public enum ChoiceEnum {
	ROCK(1),
	PAPER(2),
	SCISSOR(3);
	
	private final int score;

	public int getScore() {
		return score;
	}

	private ChoiceEnum(int score) {
		this.score = score;
	}
	
	public static ChoiceEnum fromOpponentChoice(String choice) {
		switch (choice) {
		case "A": {
			return ROCK;
		}
		case "B": {
			return PAPER;
		}
		case "C": {
			return SCISSOR;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
	}

	public static ChoiceEnum fromOwnChoice(String choice) {
		switch (choice) {
		case "X": {
			return ROCK;
		}
		case "Y": {
			return PAPER;
		}
		case "Z": {
			return SCISSOR;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
	}
}
