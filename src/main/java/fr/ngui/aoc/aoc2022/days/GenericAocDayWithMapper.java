package fr.ngui.aoc.aoc2022.days;

import java.net.URISyntaxException;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.ngui.aoc.aoc2022.exceptions.ReadingFileException;
import fr.ngui.aoc.aoc2022.exceptions.ResourceNotFoundException;
import fr.ngui.aoc.aoc2022.model.DatasFileType;
import fr.ngui.aoc.aoc2022.model.PartOfDay;

public abstract class GenericAocDayWithMapper<T> extends GenericAocDay {

	private static final Logger log = LoggerFactory.getLogger(GenericAocDayWithMapper.class);
	
	protected GenericAocDayWithMapper(int day, String expectedTestResultP1, String expectedFinalResultP1, String expectedTestResultP2, String expectedFinalResultP2) {
		super(day, expectedTestResultP1, expectedFinalResultP1, expectedTestResultP2, expectedFinalResultP2);
	}

	public abstract Function<String, T> getMapper();

	@Override
	public String getResult(PartOfDay partOfDay, DatasFileType dataType) throws URISyntaxException, ResourceNotFoundException, ReadingFileException {
		long start = System.nanoTime();
		String result = this.run(partOfDay, this.getAocDay().getDatasAsObject(dataType, getMapper()));
		long time = System.nanoTime() - start;
		log.info("    result is \033[1m{}\033[0m calculated in \033[1m{}\033[0m ms", result, time / 1000000);
		return result;
	}
}
