package fr.ngui.aoc.aoc2022.days.day10;

import java.util.Arrays;

public enum InstructionTypeEnum {
	ADDX(2, "addx"),
	NOOP(1, "noop");

	private final int cycles;
	private final String value;

	private InstructionTypeEnum(int cycles, String value) {
		this.cycles = cycles;
		this.value = value;
	}
	
	public static InstructionTypeEnum fromString(String value) {
		return Arrays.asList(InstructionTypeEnum.values()).stream()
				.filter(i ->i.value.equals(value))
				.findFirst().orElseThrow();
	}
}
