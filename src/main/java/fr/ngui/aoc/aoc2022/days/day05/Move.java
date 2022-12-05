package fr.ngui.aoc.aoc2022.days.day05;

public class Move {

	private int stacksToMove;
	private int crateFrom;
	private int crateTo;

	public Move(String line) {
		super();
		String[] splited = line.split(" ");
		this.stacksToMove = Integer.parseInt(splited[1]);
		this.crateFrom = Integer.parseInt(splited[3]);
		this.crateTo = Integer.parseInt(splited[5]);
	}

	public int getStacksToMove() {
		return stacksToMove;
	}

	public int getCrateFrom() {
		return crateFrom;
	}

	public int getCrateTo() {
		return crateTo;
	}

	@Override
	public String toString() {
		return String.format("move %s from %s to %s", stacksToMove, crateFrom, crateTo);
	}
}
