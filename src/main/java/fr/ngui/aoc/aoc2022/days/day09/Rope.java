package fr.ngui.aoc.aoc2022.days.day09;

import java.util.ArrayList;
import java.util.List;

public class Rope {

	private final List<Knot> knots = new ArrayList<>();

	public Rope(int size) {
		super();
		for (int i = 0; i <= size; i++) {
			knots.add(new Knot());
		}
	}

	public void doMove(Move m) {

		for (int i = 1; i <= m.getDistance(); i++) {

			knots.get(0).doMove(m.getDirection());
			for (int iKnot = 1; iKnot < knots.size(); iKnot++) {
				knots.get(iKnot).followPrevious(knots.get(iKnot - 1));
			}
		}
	}

	public long countTailDistinctPositionTrace() {
		return knots.get(knots.size() - 1).countDistinctPositionTrace();
	}
}
