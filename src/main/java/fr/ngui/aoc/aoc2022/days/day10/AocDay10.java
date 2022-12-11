package fr.ngui.aoc.aoc2022.days.day10;

import java.util.function.Function;
import java.util.stream.Stream;

import fr.ngui.aoc.aoc2022.days.GenericAocDayWithMapper;
import fr.ngui.aoc.aoc2022.model.PartOfDay;

public class AocDay10 extends GenericAocDayWithMapper<Instruction> {

	int xValue = 1;
	int cycle = 0;
	int totalSignalStregth = 0;
	Screen screen = new Screen();
	Pixel pixel = new Pixel();
	int numberOfPixelDraws = 0;

	public AocDay10(int day, String expectedTestResultP1, String expectedFinalResultP1, String expectedTestResultP2,
			String expectedFinalResultP2) {
		super(day, expectedTestResultP1, expectedFinalResultP1, expectedTestResultP2, expectedFinalResultP2);
	}

	@Override
	public String run(PartOfDay partOfDay, Stream<?> datas) {

		xValue = 1;
		cycle = 0;
		totalSignalStregth = 0;
		screen = new Screen();
		pixel = new Pixel();

		Stream<Instruction> instructions = (Stream<Instruction>) datas;
		parseInstructions(instructions);
		log.info(screen.toString());
		return Long.toString(PartOfDay.ONE.equals(partOfDay) ? totalSignalStregth : screen.getNumbersOfDrawnPixels());
	}

	@Override
	public Function<String, Instruction> getMapper(PartOfDay partOfDay) {
		return Instruction::new;
	}

	private void parseInstructions(Stream<Instruction> instructions) {
		instructions.forEach(this::doInstruction);
	}

	private void doInstruction(Instruction instruction) {

		// every instruction has a first cycle
		cycle++;
		doCycle();

		if (InstructionTypeEnum.ADDX.equals(instruction.getType())) {

			// Addx takes one more cycle
			cycle++;
			doCycle();

			xValue = xValue + instruction.getValue();
		}
	}

	private void doCycle() {

		pixel.setPositionFromCycle(cycle);
		if (pixel.isPixelInSprite(xValue)) {
			screen.drawPixel(pixel);
		}

		if (cycle == 20 || (cycle - 20) % 40 == 0) {
			totalSignalStregth += cycle * xValue;
		}

	}
}
