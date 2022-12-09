package fr.ngui.aoc.aoc2022.days.day09;

public class Move {

	private final DirectionEnum direction;
	private final int distance;

	public DirectionEnum getDirection() {
		return direction;
	}

	public int getDistance() {
		return distance;
	}

	@Override
	public String toString() {
		return direction + " " + distance;
	}

	public Move(String line) {
		super();
		this.direction = DirectionEnum.fromCode(line.split(" ")[0]);
		this.distance = Integer.parseInt(line.split(" ")[1]);
	}
}
