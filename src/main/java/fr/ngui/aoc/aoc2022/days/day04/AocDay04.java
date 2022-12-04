package fr.ngui.aoc.aoc2022.days.day04;

import java.util.function.Function;
import java.util.stream.Stream;

import fr.ngui.aoc.aoc2022.days.GenericAocDayWithMapper;
import fr.ngui.aoc.aoc2022.model.PartOfDay;

public class AocDay04 extends GenericAocDayWithMapper<ElfPair> {

	public AocDay04(int day, String expectedTestResultP1, String expectedFinalResultP1, String expectedTestResultP2, String expectedFinalResultP2) {
		super(day, expectedTestResultP1, expectedFinalResultP1, expectedTestResultP2, expectedFinalResultP2);
	}
	
	@Override
	public String run(PartOfDay partOfDay, Stream<?> datas) {
		long pairCovered = ((Stream<ElfPair>) datas)
				.filter(section -> PartOfDay.ONE.equals(partOfDay) ? section.elfSectionCoveredByTheOther() : section.elfSectionOverlapsByTheOther())
				.count();
		return Long.toString(pairCovered);
	}

	@Override
	public Function<String, ElfPair> getMapper(PartOfDay partOfDay) {
		return ElfPair::new;
	}
}
