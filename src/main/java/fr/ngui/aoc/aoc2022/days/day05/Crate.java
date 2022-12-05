package fr.ngui.aoc.aoc2022.days.day05;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Crate {

	private final List<String> stack = new ArrayList();
	private final int id;

	public Crate(int id) {
		super();
		this.id = id;
	}

	public List<String> getStack() {
		return stack;
	}
	
	public void addStack(String s) {
		this.stack.add(s);
	}

	@Override
	public String toString() {
		return String.format("%s -> %s", id, stack.stream().collect(Collectors.joining(", ")));
	}
}
