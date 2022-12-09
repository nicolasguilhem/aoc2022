package fr.ngui.aoc.aoc2022.days.day09;

import java.util.Arrays;

public enum DirectionEnum {
	RIGHT("R"),
	LEFT("L"),
	UP("U"),
	DOWN("D");
	
	private final String code;

	private DirectionEnum(String code) {
		this.code = code;
	}
	
	public static DirectionEnum fromCode(String code) {
		return Arrays.asList(DirectionEnum.values()).stream()
				.filter(enu -> enu.code.equals(code))
				.findFirst().orElseThrow();
	}
}
