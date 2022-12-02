package fr.ngui.aoc.aoc2022.days.day02;

import java.util.Arrays;

public enum ResultEnum {
	LOSS(0, "X", -1),
	DRAW(3, "Y", 0),
	WIN(6, "Z", 1);

	private final int score;
	private final String code;
	private final int orderValue;

	public int getScore() {
		return score;
	}
	
	public int getOrderValue() {
		return orderValue;
	}

	private ResultEnum(int score, String code, int orderValue) {
		this.score = score;
		this.code = code;
		this.orderValue = orderValue;
	}

	public static ResultEnum fromCode(String code) {
		return Arrays.stream(ResultEnum.values()).filter(r -> r.code.equals(code)).findFirst()
				.orElseThrow();
	}

	public static ResultEnum fromOrderValue(int orderValue) {
		return Arrays.stream(ResultEnum.values()).filter(r -> r.orderValue ==orderValue).findFirst()
				.orElseThrow();
	}
	
	public static ResultEnum fromRound(ChoiceEnum opponentChoice, ChoiceEnum ownChoice) {
		return fromOrderValue(ChoiceEnum.comparing().compare(opponentChoice, ownChoice));
	}
}
