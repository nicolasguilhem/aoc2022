package fr.ngui.aoc.aoc2022.days.day10;

public class Pixel {

	private int currentPosition = 0;
	private int currentLine = 0;

	public void setPositionFromCycle(int cycle) {
		currentLine = Math.floorDiv((cycle - 1), 40);
		currentPosition = cycle - currentLine * 40 - 1;
	}

	public int getCurrentPosition() {
		return currentPosition;
	}

	public int getCurrentLine() {
		return currentLine;
	}

	@Override
	public String toString() {
		return "line " + currentLine + ", pos=" + currentPosition;
	}

	public boolean isPixelInSprite(int spritePosition) {
		return currentPosition == spritePosition - 1 || currentPosition == spritePosition
				|| currentPosition == spritePosition + 1;
	}
}
