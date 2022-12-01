package fr.ngui.aoc.aoc2022.days.day01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import fr.ngui.aoc.aoc2022.days.GenericAocDay;

public class AocDay01 extends GenericAocDay {

	public AocDay01(int day, String expectedTestResult, String expectedFinalResult) {
		super(day, expectedTestResult, expectedFinalResult);
	}
	
	@Override
	public String run(Stream<?> datas) {
		
		int top3ElfCallories = toElfStream((Stream<String>) datas).sorted((e1, e2) -> Long.compare(e2.callories, e1.callories))
				.limit(3)
				.mapToInt(e -> e.callories.intValue())
				.sum();
		
		return Long.toString(top3ElfCallories);
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
			return;
		} else {
			lstElf.get(lstElf.size() - 1).callories = lstElf.get(lstElf.size() - 1).callories + Long.parseLong(s);
		}
	}
	
}
