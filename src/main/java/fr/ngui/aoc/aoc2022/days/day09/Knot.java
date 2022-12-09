package fr.ngui.aoc.aoc2022.days.day09;

import java.util.ArrayList;
import java.util.List;

public class Knot {

	private Position currentPosition = new Position();
	private List<Position> positionsHistory = new ArrayList<>();

	public Position getCurrentPosition() {
		return currentPosition;
	}
	
	public Position getPreviousPosition() {
		return positionsHistory.get(positionsHistory.size() - 1);
	}
	
	public void doMove(DirectionEnum direction) {
		positionsHistory.add(new Position(currentPosition));
		currentPosition.goOneStepToDirection(direction);
	}

	public long countDistinctPositionTrace() {
		List<Position> distinctPositions = positionsHistory.stream().distinct().toList();
		int count = distinctPositions.size();
		if (!distinctPositions.contains(currentPosition)) {
			count++;
		}
		return count;
	}
	
	public void followPrevious(Knot previousKnot) {
		positionsHistory.add(new Position(currentPosition));
		currentPosition.followPrevious(previousKnot);
	}
}
