package fr.ngui.aoc.aoc2022.days.day05;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.ngui.aoc.aoc2022.days.GenericAocDay;
import fr.ngui.aoc.aoc2022.model.PartOfDay;

public class AocDay05 extends GenericAocDay {

	private List<Crate> lstCrate = new ArrayList();
	private List<Move> lstMove = new ArrayList();

	public AocDay05(int day, String expectedTestResultP1, String expectedFinalResultP1, String expectedTestResultP2,
			String expectedFinalResultP2) {
		super(day, expectedTestResultP1, expectedFinalResultP1, expectedTestResultP2, expectedFinalResultP2);
	}

	@Override
	public String run(PartOfDay partOfDay, Stream<?> datas) {
		transformDatas((Stream<String>) datas);
		executeMoves(partOfDay);
		lstCrate.stream().map(Crate::toString).forEach(log::info);
		String result = lstCrate.stream().map(crate -> crate.getStack().get(0)).collect(Collectors.joining());
		return result;
	}

	private void transformDatas(Stream<?> datas) {

		lstCrate = new ArrayList();
		lstMove = new ArrayList();

		((Stream<String>) datas).forEach(line -> {
			if (!line.equals("") && !line.startsWith(" 1")) {
				if (line.startsWith("move")) {
					lstMove.add(new Move(line));
				} else {
					addToCrate(line);
				}
			}
		});
	}

	private void addToCrate(String line) {
		for (int i = 0; i < line.length(); i = i + 4) {
			if (lstCrate.size() - 1 < i / 4) {
				lstCrate.add(new Crate(i / 4 + 1));
			}
			if (!line.substring(i + 1, i + 2).equals(" ")) {
				lstCrate.get(i / 4).addStack(line.substring(i + 1, i + 2));
			}
		}
	}

	private void executeMoves(PartOfDay partOfDay) {
		lstMove.stream().forEach(move -> {
			if (PartOfDay.ONE.equals(partOfDay)) {
				for (int i = move.getStacksToMove(); i > 0; i--) {
					if (lstCrate.get(move.getCrateFrom() - 1).getStack().size() == 0) {
						log.info("empty !");
					} else {
						String s = lstCrate.get(move.getCrateFrom() - 1).getStack().get(0);
						lstCrate.get(move.getCrateFrom() - 1).getStack().remove(0);
						lstCrate.get(move.getCrateTo() - 1).getStack().addAll(0, List.of(s));
					}
				}
			} else {
				lstCrate.get(move.getCrateTo() - 1).getStack().addAll(0, lstCrate.get(move.getCrateFrom() - 1).getStack().subList(0, move.getStacksToMove()));
				for (int i = move.getStacksToMove(); i > 0; i--) {
					lstCrate.get(move.getCrateFrom() - 1).getStack().remove(0);
				}
			}
		});
	}
}
