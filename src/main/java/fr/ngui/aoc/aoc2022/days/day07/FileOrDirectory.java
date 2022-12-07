package fr.ngui.aoc.aoc2022.days.day07;

public interface FileOrDirectory {

	public String getName();
	public int getFileSize();
	public int getTotalSize();
	public boolean isDirectory();
}
