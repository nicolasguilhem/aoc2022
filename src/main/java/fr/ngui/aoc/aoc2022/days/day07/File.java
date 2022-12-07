package fr.ngui.aoc.aoc2022.days.day07;

public class File implements FileOrDirectory {

	private final int size;
	private final String name;
	
	public File(String line) {
		super();
		this.size = Integer.parseInt(line.split(" ")[0]);
		this.name = line.split(" ")[1];
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getFileSize() {
		return size;
	}

	@Override
	public int getTotalSize() {
		return size;
	}

	@Override
	public boolean isDirectory() {
		return false;
	}

	@Override
	public String toString() {
		return String.format("   %s - %d", name, size);
	}
}
