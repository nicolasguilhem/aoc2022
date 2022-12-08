package fr.ngui.aoc.aoc2022.days.day08;

import java.util.List;
import java.util.stream.Stream;

import fr.ngui.aoc.aoc2022.days.GenericAocDay;
import fr.ngui.aoc.aoc2022.model.PartOfDay;

public class AocDay08 extends GenericAocDay {

	public AocDay08(int day, String expectedTestResultP1, String expectedFinalResultP1, String expectedTestResultP2,
			String expectedFinalResultP2) {
		super(day, expectedTestResultP1, expectedFinalResultP1, expectedTestResultP2, expectedFinalResultP2);
	}

	@Override
	public String run(PartOfDay partOfDay, Stream<?> datas) {
		List<int[]> treeMap = generateTreeMap((Stream<String>) datas);
		int numberOfTreeVisible = 0;
		int maxViewScore = 0;
		for (int iCurrentLine = 0; iCurrentLine < treeMap.size(); iCurrentLine++) {
			int[] lineTree = treeMap.get(iCurrentLine);
			// all trees in first and last line are visible
			if (iCurrentLine == 0 || iCurrentLine == treeMap.size() - 1) {
				numberOfTreeVisible += lineTree.length;
			} else {
				for (int iCurrentColumn = 0; iCurrentColumn < lineTree.length; iCurrentColumn++) {
					// trees in first and last column are visibles
					if (iCurrentColumn == 0 || iCurrentColumn == lineTree.length - 1) {
						numberOfTreeVisible++;
					} else {
						int treeSize = lineTree[iCurrentColumn];

						int maxSizeInLineFromLeft = 0;
						int firstIndexTreeMaskingFromLeft = 0;

						for (int iCol = iCurrentColumn - 1; iCol != -1; iCol--) {
							if (lineTree[iCol] > maxSizeInLineFromLeft) {
								maxSizeInLineFromLeft = lineTree[iCol];
							}
							if (firstIndexTreeMaskingFromLeft == 0 && lineTree[iCol] >= treeSize) {
								firstIndexTreeMaskingFromLeft = iCol;
							}
						}

						int maxSizeInLineFromRight = 0;
						int firstIndexTreeMaskingFromRight = treeMap.size() - 1;

						for (int iCol = iCurrentColumn + 1; iCol < lineTree.length; iCol++) {
							if (lineTree[iCol] > maxSizeInLineFromRight) {
								maxSizeInLineFromRight = lineTree[iCol];
							}
							if (firstIndexTreeMaskingFromRight == treeMap.size() - 1 && lineTree[iCol] >= treeSize) {
								firstIndexTreeMaskingFromRight = iCol;
							}
						}

						int maxSizeInColumnFromTop = 0;
						int firstIndexTreeMaskingFromTop = 0;

						for (int iLine = iCurrentLine - 1; iLine != -1; iLine--) {
							if (treeMap.get(iLine)[iCurrentColumn] > maxSizeInColumnFromTop) {
								maxSizeInColumnFromTop = treeMap.get(iLine)[iCurrentColumn];
							}
							if (firstIndexTreeMaskingFromTop == 0 && treeMap.get(iLine)[iCurrentColumn] >= treeSize) {
								firstIndexTreeMaskingFromTop = iLine;
							}
						}

						int maxSizeInColumnFromBottom = 0;
						int firstIndexTreeMaskingFromBottom = treeMap.size() - 1;

						for (int iLine = iCurrentLine + 1; iLine < treeMap.size(); iLine++) {
							if (treeMap.get(iLine)[iCurrentColumn] > maxSizeInColumnFromBottom) {
								maxSizeInColumnFromBottom = treeMap.get(iLine)[iCurrentColumn];
							}
							if (firstIndexTreeMaskingFromBottom == treeMap.size() - 1
									&& treeMap.get(iLine)[iCurrentColumn] >= treeSize) {
								firstIndexTreeMaskingFromBottom = iLine;
							}
						}

						int numberOfThreeViewsTop = iCurrentLine - firstIndexTreeMaskingFromTop;
						int numberOfThreeViewsBottom = firstIndexTreeMaskingFromBottom - iCurrentLine;
						int numberOfThreeViewsLeft = iCurrentColumn - firstIndexTreeMaskingFromLeft;
						int numberOfThreeViewsRight = firstIndexTreeMaskingFromRight - iCurrentColumn;
						int viewScore = numberOfThreeViewsTop * numberOfThreeViewsBottom * numberOfThreeViewsLeft
								* numberOfThreeViewsRight;
						if (viewScore > maxViewScore) {
							maxViewScore = viewScore;
						}

						// visible from top ?
						if (treeSize > maxSizeInColumnFromTop) {
							numberOfTreeVisible++;
							// visible from left ?
						} else if (treeSize > maxSizeInLineFromLeft) {
							numberOfTreeVisible++;
							// visible from right ?
						} else if (treeSize > maxSizeInLineFromRight) {
							numberOfTreeVisible++;
							// visible from bottom ?
						} else if (treeSize > maxSizeInColumnFromBottom) {
							numberOfTreeVisible++;
						}

					}
				}
			}
		}
		return Integer.toString(PartOfDay.ONE.equals(partOfDay) ? numberOfTreeVisible : maxViewScore);
	}

	private List<int[]> generateTreeMap(Stream<String> datas) {
		return datas.map(this::generateTreeLine).toList();
	}

	private int[] generateTreeLine(String line) {
		int[] tab = new int[line.length()];
		for (int i = 0; i < line.length(); i++) {
			tab[i] = Integer.parseInt(line.substring(i, i + 1));
		}
		return tab;
	}
}
