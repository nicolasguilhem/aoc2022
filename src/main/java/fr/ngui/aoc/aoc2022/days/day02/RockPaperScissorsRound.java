package fr.ngui.aoc.aoc2022.days.day02;

import fr.ngui.aoc.aoc2022.model.PartOfDay;

public class RockPaperScissorsRound {

	private final ChoiceEnum opponentChoice;
	private final ChoiceEnum ownChoice;
	private final RoundResult expectedResult;

	public RockPaperScissorsRound(ChoiceEnum opponentChoice, ChoiceEnum ownChoice, RoundResult expectedResult) {
		super();
		this.opponentChoice = opponentChoice;
		this.ownChoice = ownChoice;
		this.expectedResult = expectedResult;
	}

	public RockPaperScissorsRound(String fileLine) {
		this(ChoiceEnum.fromOpponentChoice(fileLine.split(" ")[0]), ChoiceEnum.fromOwnChoice(fileLine.split(" ")[1]), RoundResult.fromString(fileLine.split(" ")[1]));
	}

	private RoundResult getResult() {
		return RoundResult.fromRound(opponentChoice, ownChoice);
	}
	
	public int getOwnScore(PartOfDay partOfDay) {
		if (partOfDay.equals(PartOfDay.ONE)) {
			return ownChoice.getScore() + getResult().getScore();
		} else {
			return getChoiceForExpectedResult().getScore() + expectedResult.getScore();
		}
	}
	
	private ChoiceEnum getChoiceForExpectedResult() {

		if (expectedResult.equals(RoundResult.DRAW)) {
			return opponentChoice;
		}
		
		if (expectedResult.equals(RoundResult.LOSS) && opponentChoice.equals(ChoiceEnum.ROCK)) {
			return ChoiceEnum.SCISSOR;
		}

		if (expectedResult.equals(RoundResult.LOSS) && opponentChoice.equals(ChoiceEnum.SCISSOR)) {
			return ChoiceEnum.PAPER;
		}

		if (expectedResult.equals(RoundResult.LOSS) && opponentChoice.equals(ChoiceEnum.PAPER)) {
			return ChoiceEnum.ROCK;
		}

		if (expectedResult.equals(RoundResult.WIN) && opponentChoice.equals(ChoiceEnum.ROCK)) {
			return ChoiceEnum.PAPER;
		}

		if (expectedResult.equals(RoundResult.WIN) && opponentChoice.equals(ChoiceEnum.SCISSOR)) {
			return ChoiceEnum.ROCK;
		}

		if (expectedResult.equals(RoundResult.WIN) && opponentChoice.equals(ChoiceEnum.PAPER)) {
			return ChoiceEnum.SCISSOR;
		}
		
		return ChoiceEnum.ROCK;
	}
}
