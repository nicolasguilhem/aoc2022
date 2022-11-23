package fr.ngui.aoc.aoc2022.days;

import java.net.URISyntaxException;
import java.util.function.Function;

import fr.ngui.aoc.aoc2022.exceptions.ReadingFileException;
import fr.ngui.aoc.aoc2022.exceptions.ResourceNotFoundException;
import fr.ngui.aoc.aoc2022.model.DatasFileType;

public abstract class GenericAocDayWithMapper<T> extends GenericAocDay {

	protected GenericAocDayWithMapper(int day, String expectedTestResult, String expectedFinalResult) {
		super(day, expectedTestResult, expectedFinalResult);
	}

	public abstract Function<String, T> getMapper();

	@Override
	public String getResult(DatasFileType dataType) throws URISyntaxException, ResourceNotFoundException, ReadingFileException {
		return this.run(this.getAocDay().getDatasAsObject(dataType, getMapper()));
	}
}
