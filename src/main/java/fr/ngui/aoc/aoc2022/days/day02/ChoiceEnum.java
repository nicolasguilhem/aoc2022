package fr.ngui.aoc.aoc2022.days.day02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

public enum ChoiceEnum {
	ROCK(1, "A", "X"), PAPER(2, "B", "Y"), SCISSOR(3, "C", "Z");

	private final int score;
	private final String opponentCode;
	private final String ownCode;

	public int getScore() {
		return score;
	}

	private ChoiceEnum(int score, String opponentCode, String ownCode) {
		this.score = score;
		this.opponentCode = opponentCode;
		this.ownCode = ownCode;
	}

	public static ChoiceEnum fromOpponentChoice(String choice) {
		return fromProperty(choice, c -> c.opponentCode);
	}

	public static ChoiceEnum fromOwnChoice(String choice) {
		return fromProperty(choice, c -> c.ownCode);
	}

	private static ChoiceEnum fromProperty(String choice, Function<ChoiceEnum, String> propertyGetter) {
		return Arrays.stream(ChoiceEnum.values()).filter(c -> propertyGetter.apply(c).equals(choice)).findFirst()
				.orElseThrow();
	}

	/**
	 * Comparator comparing 2 choices to determine the result of a round
	 * @return
	 */
	public static Comparator<ChoiceEnum> comparing() {
		return (c1, c2) -> {
			// if choices are equals, its a DRAW
			if (c1.equals(c2)) {
				return 0;
			}

			// ROCK beats SCISSORS, SCISSORS beats PAPER and PAPER beats ROCK
			if (c1.equals(ChoiceEnum.ROCK) && c2.equals(ChoiceEnum.SCISSOR)
					|| c1.equals(ChoiceEnum.SCISSOR) && c2.equals(ChoiceEnum.PAPER)
					|| c1.equals(ChoiceEnum.PAPER) && c2.equals(ChoiceEnum.ROCK)) {
				return -1;
			}

			// Others combinations are a WIN
			return 1;
		};
	}
}
