package fr.ngui.aoc.aoc2022.days.day10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Screen {

	private static final char pixelMark = '#';

	private final List<String> lines = new ArrayList<>();

	public Screen() {
		super();
		for (int i = 0; i < 6; i++) {
			lines.add(" ".repeat(40));
		}
	}

	@Override
	public String toString() {
		String display = lines.stream().collect(Collectors.joining("\n"));
		return "\n" + display;
	}

	public void drawPixel(Pixel pixel) {
		String oldLine = lines.get(pixel.getCurrentLine());
		String newLine = oldLine.substring(0, pixel.getCurrentPosition()) + pixelMark
				+ oldLine.substring(pixel.getCurrentPosition() + 1);
		lines.set(pixel.getCurrentLine(), newLine);
	}

	public long getNumbersOfDrawnPixels() {
		return lines.stream().mapToLong(line -> line.codePoints().filter(ch -> ch == pixelMark).count()).sum();
	}
}
