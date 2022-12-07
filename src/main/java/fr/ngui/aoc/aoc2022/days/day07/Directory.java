package fr.ngui.aoc.aoc2022.days.day07;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Directory implements FileOrDirectory {

	private List<FileOrDirectory> lstFilesOrDirectories = new ArrayList<>();
	private final String name;
	private final Directory parent;

	public Directory(String line, Directory parent) {
		super();
		this.name = line.split(" ")[2];
		this.parent = parent;
	}

	public Directory getParent() {
		return parent;
	}

	public List<FileOrDirectory> getLstFilesOrDirectories() {
		return lstFilesOrDirectories;
	}

	public String getParentName() {
		String parentName = "";
		if (this.parent != null && !this.parent.getName().equals("")) {
			parentName = this.parent.getName();
			if (!this.parent.getParentName().equals("")) {
				parentName = this.parent.getParentName() + "/" + parentName;
			}
		}
		return parentName;
	}

	public List<Directory> getDirsAndSubDirs() {
		List<Directory> dirs = new ArrayList();
		dirs.addAll(lstFilesOrDirectories.stream().filter(FileOrDirectory::isDirectory).map(Directory.class::cast)
				.toList());

		dirs.addAll(dirs.stream().map(Directory::getDirsAndSubDirs).flatMap(List::stream).toList());

		return dirs;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getFileSize() {
		return lstFilesOrDirectories.stream().filter(fOrD -> !fOrD.isDirectory()).mapToInt(FileOrDirectory::getFileSize)
				.sum();
	}

	@Override
	public int getTotalSize() {
		return getFileSize() + getDirsAndSubDirs().stream().mapToInt(FileOrDirectory::getFileSize).sum();
	}

	@Override
	public boolean isDirectory() {
		return true;
	}

	public void addFile(String line) {
		this.lstFilesOrDirectories.add(new File(line));
	}

	public void addDirectory(Directory dir) {
		this.lstFilesOrDirectories.add(dir);
	}

	@Override
	public String toString() {
		String fileOrDirs = lstFilesOrDirectories.stream().filter(FileOrDirectory::isDirectory)
				.map(FileOrDirectory::toString).collect(Collectors.joining("\n"));
		return String.format("\nDIR %s/%s - %d - %d%s", getParentName(), name, this.getFileSize(), this.getTotalSize(),
				fileOrDirs);
	}
}
