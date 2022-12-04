package fr.ngui.aoc.aoc2022.days.day04;

public class ElfPair {

	private ElfSection firstElfSection;
	private ElfSection secondElfSection;
	
	public ElfPair(String line) {
		super();
		this.firstElfSection = new ElfSection(line.split(",")[0]);
		this.secondElfSection = new ElfSection(line.split(",")[1]);
	}

	@Override
	public String toString() {
		return String.format("%s / %s", firstElfSection.toString(), secondElfSection.toString());
	}

	public boolean elfSectionCoveredByTheOther() {
		return firstElfSection.contains(secondElfSection) || secondElfSection.contains(firstElfSection);
	}

	public boolean elfSectionOverlapsByTheOther() {
		return firstElfSection.isOverLapping(secondElfSection) || secondElfSection.isOverLapping(firstElfSection);
	}
}
