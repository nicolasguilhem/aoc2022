package fr.ngui.aoc.aoc2022.days.day02;

import java.util.Arrays;

import fr.ngui.aoc.aoc2022.model.PartOfDay;

public class RockPaperScissorsRound {

	private final ChoiceEnum opponentChoice;
	private final ChoiceEnum ownChoice;
	private final ResultEnum result;

	public RockPaperScissorsRound(ChoiceEnum opponentChoice, Object choiceOrResult) {
		super();
		this.opponentChoice = opponentChoice;
		if (choiceOrResult instanceof ChoiceEnum choice) {
			this.ownChoice = choice;
			this.result = getResultFromChoices();
		} else if(choiceOrResult instanceof ResultEnum expectedResult) {
			this.result = expectedResult;
			this.ownChoice = getChoiceFromResult();
		} else {
			throw new IllegalArgumentException();
		}
	}

	public RockPaperScissorsRound(String fileLine, PartOfDay partOfDay) {
		this(ChoiceEnum.fromOpponentChoice(fileLine.split(" ")[0]),
				partOfDay.equals(PartOfDay.ONE) ? ChoiceEnum.fromOwnChoice(fileLine.split(" ")[1]) : ResultEnum.fromCode(fileLine.split(" ")[1]));
	}

	private ResultEnum getResultFromChoices() {
		return ResultEnum.fromRound(opponentChoice, ownChoice);
	}
	
	public int getTotalScore() {
		return ownChoice.getScore() + this.result.getScore();
	}
	
	private ChoiceEnum getChoiceFromResult() {
		return Arrays.stream(ChoiceEnum.values())
			.filter(choice -> ChoiceEnum.comparing().compare(opponentChoice, choice) == result.getOrderValue())
			.findFirst()
			.orElseThrow();
	}
}
