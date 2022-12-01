package fr.ngui.aoc.aoc2022.days.day01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import fr.ngui.aoc.aoc2022.days.GenericAocDay;
import fr.ngui.aoc.aoc2022.model.PartOfDay;

public class AocDay01 extends GenericAocDay {

	public AocDay01(int day, String expectedTestResultP1, String expectedFinalResultP1, String expectedTestResultP2, String expectedFinalResultP2) {
		super(day, expectedTestResultP1, expectedFinalResultP1, expectedTestResultP2, expectedFinalResultP2);
	}
	
	@Override
	public String run(PartOfDay partOfDay, Stream<?> datas) {
		return Long.toString(getTopNElfCallories(toElfStream((Stream<String>) datas), partOfDay == PartOfDay.ONE ? 1 : 3));
	}
	
	private int getTopNElfCallories(Stream<Elf> elfStream, int elfNumber) {
		return elfStream.sorted((e1, e2) -> Long.compare(e2.callories, e1.callories))
				.limit(elfNumber)
				.mapToInt(e -> e.callories.intValue())
				.sum();
	}

	private Stream<Elf> toElfStream(Stream<String> datas) {
		List<Elf> lstElf = new ArrayList<>();
		lstElf.add(new Elf(0L));
		datas.forEach(s -> buildElf(s, lstElf));
		return lstElf.stream();
	}

	private void buildElf(String s, List<Elf> lstElf) {
		if (s.equals("")) {
			lstElf.add(new Elf(0L));
		} else {
			lstElf.get(lstElf.size() - 1).callories = lstElf.get(lstElf.size() - 1).callories + Long.parseLong(s);
		}
	}
}
