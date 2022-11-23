package fr.ngui.aoc.aoc2022.days.day00;

import java.util.stream.Stream;

import fr.ngui.aoc.aoc2022.days.GenericAocDay;

public class AocDay00 extends GenericAocDay {

	public AocDay00(int day, String expectedTestResult, String expectedFinalResult) {
		super(day, expectedTestResult, expectedFinalResult);
	}
	
	@Override
	public String run(Stream<?> datas) {
		var sum = ((Stream<String>) datas).mapToLong(Long::parseLong).sum();
		return Long.toString(sum);
	}
}
