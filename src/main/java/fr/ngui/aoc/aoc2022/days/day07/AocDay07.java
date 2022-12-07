package fr.ngui.aoc.aoc2022.days.day07;

import java.util.stream.Stream;

import fr.ngui.aoc.aoc2022.days.GenericAocDay;
import fr.ngui.aoc.aoc2022.model.PartOfDay;

public class AocDay07 extends GenericAocDay {

	public AocDay07(int day, String expectedTestResultP1, String expectedFinalResultP1, String expectedTestResultP2,
			String expectedFinalResultP2) {
		super(day, expectedTestResultP1, expectedFinalResultP1, expectedTestResultP2, expectedFinalResultP2);
	}

	@Override
	public String run(PartOfDay partOfDay, Stream<?> datas) {
		Directory root = buildDirectories((Stream<String>) datas);
		
		int totalSize = root.getDirsAndSubDirs().stream()
			.filter(dir -> dir.getTotalSize() < 100000)
			.mapToInt(Directory::getTotalSize)
			.sum();
		if (PartOfDay.ONE.equals(partOfDay)) {
			return Integer.toString(totalSize);
		}
		
		int availableSize = 70000000;
		int sizeNeededForUpdate = 30000000;
		int currentTotalFileSize = root.getTotalSize();
		int unUsedSpace = availableSize - currentTotalFileSize;
		int minimumSizeToFree = sizeNeededForUpdate - unUsedSpace;

		int dirWithMinimumSize = root.getDirsAndSubDirs().stream()
			.filter(dir -> dir.getTotalSize() >= minimumSizeToFree)
			.sorted((dir1, dir2) -> dir1.getTotalSize() - dir2.getTotalSize())
			.mapToInt(Directory::getTotalSize)
			.findFirst()
			.orElseThrow();
		
		return Integer.toString(dirWithMinimumSize);
	}

	private Directory buildDirectories(Stream<String> datas) {
		
		Directory directory = null;
		Directory startingDir = null;
		
		for (String line : datas.toList()) {
			if (line.startsWith("$ cd ..") && directory != null) {
				directory = directory.getParent();
			} else if (line.startsWith("$ cd ")) {
				var previousDir = directory;
				directory = new Directory(line, previousDir);
				if (previousDir == null) {
					startingDir = directory;
				} else {
					previousDir.addDirectory(directory);
				}
			} else if (line.startsWith("$ ls")) {
				// nothing to do
			} else if (line.startsWith("dir ")) {
				// nothing to do
			} else {
				directory.addFile(line);
			}
		}
		
		return startingDir;
	}
}
