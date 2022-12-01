package fr.ngui.aoc.aoc2022.days;

import java.net.URISyntaxException;
import java.util.function.Function;

import fr.ngui.aoc.aoc2022.exceptions.ReadingFileException;
import fr.ngui.aoc.aoc2022.exceptions.ResourceNotFoundException;
import fr.ngui.aoc.aoc2022.model.DatasFileType;
import fr.ngui.aoc.aoc2022.model.PartOfDay;

public abstract class GenericAocDayWithMapper<T> extends GenericAocDay {

	protected GenericAocDayWithMapper(int day, String expectedTestResultP1, String expectedFinalResultP1, String expectedTestResultP2, String expectedFinalResultP2) {
		super(day, expectedTestResultP1, expectedFinalResultP1, expectedTestResultP2, expectedFinalResultP2);
	}

	public abstract Function<String, T> getMapper();

	@Override
	public String getResult(PartOfDay partOfDay, DatasFileType dataType) throws URISyntaxException, ResourceNotFoundException, ReadingFileException {
		return this.run(partOfDay, this.getAocDay().getDatasAsObject(dataType, getMapper()));
	}
}
