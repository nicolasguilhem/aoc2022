package fr.ngui.aoc.aoc2022.days.day03;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.ngui.aoc.aoc2022.days.GenericAocDayWithMapper;
import fr.ngui.aoc.aoc2022.model.PartOfDay;

public class AocDay03 extends GenericAocDayWithMapper<Rucksack> {

	public AocDay03(int day, String expectedTestResultP1, String expectedFinalResultP1, String expectedTestResultP2, String expectedFinalResultP2) {
		super(day, expectedTestResultP1, expectedFinalResultP1, expectedTestResultP2, expectedFinalResultP2);
	}
	
	@Override
	public String run(PartOfDay partOfDay, Stream<?> datas) {
		List<Rucksack> lstRucksack = ((Stream<Rucksack>) datas).collect(Collectors.toList());
		int result = lstRucksack.stream().mapToInt(Rucksack::getValueItemInBothCompartment).sum();
		if (PartOfDay.ONE.equals(partOfDay)) {
			return Integer.toString(result);
		}
		
		final AtomicInteger counter = new AtomicInteger();
		final Collection<List<Rucksack>> lstGroup = lstRucksack.stream()
		    .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / 3))
		    .values();
		result = lstGroup.stream()
	    	.map(list -> new RuckstackGroup(list.get(0), list.get(1), list.get(2)))
	    	.mapToInt(RuckstackGroup::getValueItemInAllStacks)
	    	.sum();
		return Integer.toString(result);
	}

	@Override
	public Function<String, Rucksack> getMapper(PartOfDay partOfDay) {
		return Rucksack::new;
	}
}
