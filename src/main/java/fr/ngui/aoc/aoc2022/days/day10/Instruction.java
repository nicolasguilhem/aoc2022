package fr.ngui.aoc.aoc2022.days.day10;

public class Instruction {

	private final InstructionTypeEnum type;
	private final int value;

	public Instruction(String line) {
		super();
		this.type = InstructionTypeEnum.fromString(line.split(" ")[0]);
		this.value = InstructionTypeEnum.ADDX.equals(type) ? Integer.parseInt(line.split(" ")[1]) : 0;
	}

	public InstructionTypeEnum getType() {
		return type;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return type + " " + value;
	}
}
