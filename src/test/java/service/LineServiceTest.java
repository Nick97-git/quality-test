package service;

import java.util.List;
import model.Line;
import org.junit.Assert;
import org.junit.Test;
import service.impl.FileServiceImpl;
import service.impl.LineServiceImpl;
import service.impl.ParserServiceImpl;

public class LineServiceTest {
    private static final String PATH_TO_TEST_FILE = "src/test/resources/testFile.txt";
    private static final String PATH_TO_FILE_WITH_WAITING_TIMES =
            "src/test/resources/fileWithWaitingTimes.txt";
    private static final String PATH_TO_FILE_WITH_QUERIES =
            "src/test/resources/fileWithQueries.txt";
    private final FileService fileService = new FileServiceImpl();
    private final ParserService parserService = new ParserServiceImpl();
    private final LineService lineService = new LineServiceImpl();

    @Test
    public void checkAverageTimesOk() {
        List<String> expected = List.of("83", "100", "-");
        List<String> actual = getListOfAverageTimes(PATH_TO_TEST_FILE);
        Assert.assertEquals(3, actual.size());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkAverageTimesOnlyWithWaitingTimes() {
        List<String> averageTimes = getListOfAverageTimes(PATH_TO_FILE_WITH_WAITING_TIMES);
        Assert.assertEquals(0, averageTimes.size());
    }

    @Test
    public void checkAverageTimesOnlyWithQueries() {
        List<String> expected = List.of("-", "-", "-");
        List<String> actual = getListOfAverageTimes(PATH_TO_FILE_WITH_QUERIES);
        Assert.assertEquals(3, actual.size());
        Assert.assertEquals(expected, actual);
    }

    private List<String> getListOfAverageTimes(String path) {
        List<String> inputData = fileService.readFromFile(path);
        List<Line> lines = parserService.parseLines(inputData);
        return lineService.getAverageTimes(lines);
    }
}
