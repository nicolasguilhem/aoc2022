package fr.ngui.aoc.aoc2022.model;

import java.net.URISyntaxException;
import java.util.function.Function;
import java.util.stream.Stream;

import fr.ngui.aoc.aoc2022.exceptions.ReadingFileException;
import fr.ngui.aoc.aoc2022.exceptions.ResourceNotFoundException;
import fr.ngui.aoc.aoc2022.utils.FileReaderUtils;

public class AocDay {

	private final int dayNumber;
	private final DataWithExpectedResult testDatas;
	private final DataWithExpectedResult finalDatas;

	public AocDay(int dayNumber, String expectedTestResult, String expectedFinalResult) {
		super();
		this.dayNumber = dayNumber;
		this.testDatas = new DataWithExpectedResult(DatasFileType.TEST, expectedTestResult);
		this.finalDatas = new DataWithExpectedResult(DatasFileType.FINAL, expectedFinalResult);
	}

	public Stream<String> getDatas(DatasFileType datasType) throws URISyntaxException, ResourceNotFoundException, ReadingFileException {
		return FileReaderUtils.readFileAsStreamString(this.getDatasToUse(datasType).getFilePath(dayNumber));
	}

	public <T> Stream<T> getDatasAsObject(DatasFileType datasType, Function<String, T> mapper) throws URISyntaxException, ResourceNotFoundException, ReadingFileException {
		return FileReaderUtils.readFileAsStreamObj(this.getDatasToUse(datasType).getFilePath(dayNumber), mapper);
	}

	public String getExpectedResult(DatasFileType datasType) {
		return this.getDatasToUse(datasType).getExpectedResult();
	}
	
	private DataWithExpectedResult getDatasToUse(DatasFileType datasType) {
		return datasType == DatasFileType.TEST ? this.testDatas : this.finalDatas;
	}
}
