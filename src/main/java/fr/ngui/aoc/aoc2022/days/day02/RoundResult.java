package fr.ngui.aoc.aoc2022.days.day02;

public enum RoundResult {
	LOSS(0),
	DRAW(3),
	WIN(6);

	private final int score;

	public int getScore() {
		return score;
	}

	private RoundResult(int score) {
		this.score = score;
	}

	public static RoundResult fromString(String expectedResult) {
		switch (expectedResult) {
		case "X": {
			return LOSS;
		}
		case "Y": {
			return DRAW;
		}
		case "Z": {
			return WIN;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + expectedResult);
		}
	}
	
	public static RoundResult fromRound(ChoiceEnum opponentChoice, ChoiceEnum ownChoice) {
		if (opponentChoice.equals(ownChoice)) {
			return DRAW;
		}
		
		if (opponentChoice.equals(ChoiceEnum.ROCK) && ownChoice.equals(ChoiceEnum.SCISSOR)) {
			return LOSS;
		}

		if (opponentChoice.equals(ChoiceEnum.SCISSOR) && ownChoice.equals(ChoiceEnum.PAPER)) {
			return LOSS;
		}

		if (opponentChoice.equals(ChoiceEnum.PAPER) && ownChoice.equals(ChoiceEnum.ROCK)) {
			return LOSS;
		}
		
		return WIN;
	}
}
