package fr.ngui.aoc.aoc2022.days.day04;

public class ElfSection {

	private int beginingIndex;
	private int endingIndex;

	public int getBeginingIndex() {
		return beginingIndex;
	}

	public int getEndingIndex() {
		return endingIndex;
	}

	public ElfSection(String section) {
		super();
		this.beginingIndex = Integer.parseInt(section.split("-")[0]);
		this.endingIndex = Integer.parseInt(section.split("-")[1]);
	}

	@Override
	public String toString() {
		return String.format("[%s - %s]", beginingIndex, endingIndex);
	}

	/**
	 * return true if this section contains the other one
	 * @param otherSection
	 * @return boolean
	 */
	public boolean contains(ElfSection otherSection) {
		return this.beginingIndex <= otherSection.beginingIndex
				&& this.endingIndex >= otherSection.endingIndex;
	}

	/**
	 * return true if this section overlaps the other one
	 * @param otherSection
	 * @return boolean
	 */
	public boolean isOverLapping(ElfSection otherSection) {
		return this.beginingIndex <= otherSection.endingIndex
				&& this.endingIndex >= otherSection.beginingIndex;
	}
}
