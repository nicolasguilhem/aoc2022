package fr.ngui.aoc.aoc2022.days.day02;

import java.util.function.Function;
import java.util.stream.Stream;

import fr.ngui.aoc.aoc2022.days.GenericAocDayWithMapper;
import fr.ngui.aoc.aoc2022.model.PartOfDay;

public class AocDay02 extends GenericAocDayWithMapper<RockPaperScissorsRound> {

	public AocDay02(int day, String expectedTestResultP1, String expectedFinalResultP1, String expectedTestResultP2, String expectedFinalResultP2) {
		super(day, expectedTestResultP1, expectedFinalResultP1, expectedTestResultP2, expectedFinalResultP2);
	}
	
	@Override
	public String run(PartOfDay partOfDay, Stream<?> datas) {
		int result = ((Stream<RockPaperScissorsRound>) datas).mapToInt(RockPaperScissorsRound::getTotalScore).sum();
		return Integer.toString(result);
	}

	@Override
	public Function<String, RockPaperScissorsRound> getMapper(PartOfDay partOfDay) {
		return line -> new RockPaperScissorsRound(line, partOfDay);
	}
}
