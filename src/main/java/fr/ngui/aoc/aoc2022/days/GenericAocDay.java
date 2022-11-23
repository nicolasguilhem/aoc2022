package fr.ngui.aoc.aoc2022.days;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URISyntaxException;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.ngui.aoc.aoc2022.exceptions.ReadingFileException;
import fr.ngui.aoc.aoc2022.exceptions.ResourceNotFoundException;
import fr.ngui.aoc.aoc2022.model.AocDay;
import fr.ngui.aoc.aoc2022.model.DatasFileType;

public abstract class GenericAocDay {

	private static final Logger log = LoggerFactory.getLogger(GenericAocDay.class);
	private final AocDay aocDay;

	protected GenericAocDay(int day, String expectedTestResult, String expectedFinalResult) {
		this.aocDay = new AocDay(day, expectedTestResult, expectedFinalResult);
	}

	public AocDay getAocDay() {
		return aocDay;
	}

	public abstract String run(Stream<?> datas);
	
	public String getResult(DatasFileType dataType) throws URISyntaxException, ResourceNotFoundException, ReadingFileException {
		return this.run(this.getAocDay().getDatas(dataType));
	}

    private static String getAocDayClassFullyQualifiedName(int day) {
    	return String.format("%s.day%02d.AocDay%02d", GenericAocDay.class.getPackageName(), day, day);
    }

    public static void main(String[] args) {
        try {
            int day = Integer.parseInt(args[0]);
            String expectedTestResult = args[1];
            String expectedFinalResult = args[2];
            log.info("Starting Advent of code for day {}", day);
            Class<GenericAocDay> clazz = (Class<GenericAocDay>) Class.forName(GenericAocDay.getAocDayClassFullyQualifiedName(day));
            GenericAocDay instance = clazz.getDeclaredConstructor(int.class, String.class, String.class)
            		.newInstance(day, expectedTestResult, expectedFinalResult);

            for (DatasFileType type  : DatasFileType.values()) {
            	log.info("<<< Getting result for {}, expecting {}", type, instance.getAocDay().getExpectedResult(type));
            	String testResults = instance.getResult(type);
            	log.info("    result is {}", testResults);
                assertThat(testResults).isEqualTo(instance.getAocDay().getExpectedResult(type));
            	log.info(">>> Result is the one expected !!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    
}
