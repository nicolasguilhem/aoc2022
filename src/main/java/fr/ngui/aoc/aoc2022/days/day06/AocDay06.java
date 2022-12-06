package fr.ngui.aoc.aoc2022.days.day06;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.ngui.aoc.aoc2022.days.GenericAocDay;
import fr.ngui.aoc.aoc2022.model.PartOfDay;

public class AocDay06 extends GenericAocDay {

	public AocDay06(int day, String expectedTestResultP1, String expectedFinalResultP1, String expectedTestResultP2,
			String expectedFinalResultP2) {
		super(day, expectedTestResultP1, expectedFinalResultP1, expectedTestResultP2, expectedFinalResultP2);
	}

	@Override
	public String run(PartOfDay partOfDay, Stream<?> datas) {
		final int result = findStartOfMarker((Stream<String>) datas, PartOfDay.ONE.equals(partOfDay) ? 4 : 14);
		return Integer.toString(result);
	}

	private int findStartOfMarker(Stream<String> datas, int distinctNumbers) {
		String data = datas.findFirst().orElseThrow();
		char[] chars = data.toCharArray();
		for (int i=0; i < chars.length; i++) {
			List<Character> firstChars = data.substring(i, i+distinctNumbers).chars().mapToObj(c -> (char) c).toList();
			boolean sameCharacterInList = sameCharacterInList(firstChars);
			//log.info("{}, {}, {}", firstChars, sameCharacterInList, chars[i+distinctNumbers]);
			if (sameCharacterInList) {
				continue;
			}
			if (!firstChars.contains(chars[i+distinctNumbers])) {
				return i+distinctNumbers;
			}
		}
		return 0;
	}
	
	private boolean sameCharacterInList(List<Character> list) {
		for (int j=0; j < list.size(); j++) {
			List<Character> nextChars = list.subList(j+1, list.size());
			if (nextChars.contains(list.get(j))) {
				return true;
			}
		}
		return false;
	}
}
