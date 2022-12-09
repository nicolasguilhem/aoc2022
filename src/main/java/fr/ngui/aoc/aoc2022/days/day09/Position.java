package fr.ngui.aoc.aoc2022.days.day09;

import java.util.Objects;

public class Position {

	private int x = 0;
	private int y = 0;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Position() {
		super();
	}

	public Position(Position pos) {
		this();
		this.setX(pos.x);
		this.setY(pos.y);
	}

	@Override
	public String toString() {
		return String.format("[%d,%d]", x, y);
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Position)) {
			return false;
		}
		Position otherPos = (Position) obj;
		return this.x == otherPos.x && this.y == otherPos.y;
	}

	public boolean isNextTo(Position otherPosition) {
		return (this.x == otherPosition.x + 1 || this.x == otherPosition.x - 1 || this.x == otherPosition.x)
				&& (this.y == otherPosition.y + 1 || this.y == otherPosition.y - 1 || this.y == otherPosition.y);
	}

	public void goOneStepToDirection(DirectionEnum direction) {
		switch (direction) {
		case RIGHT: {
			this.x++;
			break;
		}
		case LEFT: {
			this.x--;
			break;
		}
		case UP: {
			this.y++;
			break;
		}
		case DOWN: {
			this.y--;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + direction);
		}
	}

	public void followPrevious(Knot previousKnot) {

		Position previousKnotPotision = previousKnot.getCurrentPosition();

		// If tail is overlapping head or next to it, nothing to do
		if (previousKnotPotision.equals(this) || previousKnotPotision.isNextTo(this)) {
			return;
		}

		int distanceX = previousKnotPotision.getX() - this.x;
		if (Math.abs(distanceX) > 0) {
			if (distanceX < 0) {
				this.x--;
			} else {
				this.x++;
			}
		}

		int distanceY = previousKnotPotision.getY() - this.y;
		if (Math.abs(distanceY) > 0) {
			if (distanceY < 0) {
				this.y--;
			} else {
				this.y++;
			}
		}
	}
}
