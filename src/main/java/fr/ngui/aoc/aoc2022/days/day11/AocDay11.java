package fr.ngui.aoc.aoc2022.days.day11;

import java.util.ArrayList;
import java.util.List;
import java.util.function.LongUnaryOperator;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.assertj.core.util.Arrays;

import fr.ngui.aoc.aoc2022.days.GenericAocDay;
import fr.ngui.aoc.aoc2022.model.PartOfDay;

public class AocDay11 extends GenericAocDay {

	List<Monkey> lstMonkey;

	public AocDay11(int day, String expectedTestResultP1, String expectedFinalResultP1, String expectedTestResultP2,
			String expectedFinalResultP2) {
		super(day, expectedTestResultP1, expectedFinalResultP1, expectedTestResultP2, expectedFinalResultP2);
	}

	@Override
	public String run(PartOfDay partOfDay, Stream<?> datas) {
		lstMonkey = ((Stream<String>) datas).collect(monkeyCollector());
		final int numberOfRounds = PartOfDay.ONE.equals(partOfDay) ? 20 : 10000;
		if (PartOfDay.ONE.equals(partOfDay)) {
			IntStream.rangeClosed(1, numberOfRounds).forEach(round -> this.runRound(value -> value / 3L));
		} else {
			long val = lstMonkey.stream().mapToInt(m -> m.getTest().getValue()).reduce(1, (a, b) -> a * b);
			IntStream.rangeClosed(1, numberOfRounds).forEach(round -> this.runRound(value -> value % val));
		}
		lstMonkey.sort(Monkey.compareByInspectedItems);
		long monkeyValue = lstMonkey.stream().limit(2).mapToLong(Monkey::getInspectedItems).reduce(1, (a, b) -> a * b);
		return Long.toString(monkeyValue);
	}

	private static Collector<String, List<Monkey>, List<Monkey>> monkeyCollector() {
		return Collector.of(ArrayList<Monkey>::new, (list, value) -> {
			Monkey monkey = (list.isEmpty() ? null : list.get(list.size() - 1));
			if (monkey == null || value.equals("")) {
				list.add(new Monkey());
			} else {
				if (value.startsWith("  Starting items: ")) {
					Arrays.asList(value.substring("  Starting items: ".length()).split(", "))
							.forEach(str -> list.get(list.size() - 1).addItem(Long.parseLong((String) str)));
				} else if (value.startsWith("  Operation: new = old ")) {
					list.get(list.size() - 1).setOperation(value.substring("  Operation: new = old ".length()));
				} else if (value.startsWith("  Test: divisible by ")) {
					list.get(list.size() - 1).setTest(new Test(value.substring("  Test: divisible by ".length())));
				} else if (value.startsWith("    If true: throw to monkey ")) {
					list.get(list.size() - 1).getTest()
							.setMonkeyToThrowIfTrue(value.substring("    If true: throw to monkey ".length()));
				} else if (value.startsWith("    If false: throw to monkey ")) {
					list.get(list.size() - 1).getTest()
							.setMonkeyToThrowIfFalse(value.substring("    If false: throw to monkey ".length()));
				}
			}

		}, (r1, r2) -> {
			throw new UnsupportedOperationException("Parallel processing not supported");
		});
	}
	
	private void runRound(LongUnaryOperator afterInspection) {
		lstMonkey.forEach(m -> m.inspectItems(lstMonkey, afterInspection));
	}
}
