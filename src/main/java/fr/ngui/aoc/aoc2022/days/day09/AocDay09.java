package fr.ngui.aoc.aoc2022.days.day09;

import java.util.function.Function;
import java.util.stream.Stream;

import fr.ngui.aoc.aoc2022.days.GenericAocDayWithMapper;
import fr.ngui.aoc.aoc2022.model.PartOfDay;

public class AocDay09 extends GenericAocDayWithMapper<Move> {

	public AocDay09(int day, String expectedTestResultP1, String expectedFinalResultP1, String expectedTestResultP2,
			String expectedFinalResultP2) {
		super(day, expectedTestResultP1, expectedFinalResultP1, expectedTestResultP2, expectedFinalResultP2);
	}

	@Override
	public String run(PartOfDay partOfDay, Stream<?> datas) {
		Stream<Move> moves = (Stream<Move>) datas;
		Rope rope = new Rope(PartOfDay.ONE == partOfDay ? 1 : 9);
		moves.forEach(rope::doMove);
		return Long.toString(rope.countTailDistinctPositionTrace());
	}

	@Override
	public Function<String, Move> getMapper(PartOfDay partOfDay) {
		return Move::new;
	}
}
