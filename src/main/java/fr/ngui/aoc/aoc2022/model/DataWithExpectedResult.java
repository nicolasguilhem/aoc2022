package fr.ngui.aoc.aoc2022.model;

public class DataWithExpectedResult extends InputDatas {

	private final String expectedResult;
	
	public DataWithExpectedResult(DatasFileType dataFileType, String expectedResult) {
		super(dataFileType);
		this.expectedResult = expectedResult;
	}

	public String getExpectedResult() {
		return expectedResult;
	}
}
