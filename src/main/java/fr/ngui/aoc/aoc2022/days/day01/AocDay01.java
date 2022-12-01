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
		Long calloriesMax = 0L;
		List<Elf> lstElf = new ArrayList<>();
		lstElf.add(new Elf(0L));
		((Stream<String>) datas).forEach(s -> buildElf(s, lstElf));
		
		for (Elf elf : lstElf) {
			if (elf.callories > calloriesMax) {
				calloriesMax = elf.callories;
			}
		}
		
		return Long.toString(calloriesMax);
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
