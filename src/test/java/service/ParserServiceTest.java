package service;

import java.time.LocalDate;
import java.util.List;
import model.Line;
import org.junit.Assert;
import org.junit.Test;
import service.impl.FileServiceImpl;
import service.impl.ParserServiceImpl;

public class ParserServiceTest {
    public static final String PATH_TO_TEST_FILE = "src/test/resources/testFile.txt";
    private final ParserService parserService = new ParserServiceImpl();
    private final FileService fileService = new FileServiceImpl();

    @Test
    public void checkParserOk() {
        List<String> lines = fileService.readFromFile(PATH_TO_TEST_FILE);
        List<Line> records = parserService.parseLines(lines);
        Assert.assertEquals(7, records.size());
        Line expected = Line.newBuilder()
                .setType("C")
                .setWaitingTime(83)
                .setDate(LocalDate.of(2012, 10, 15))
                .setQuestionType("8.15.1")
                .setResponseType("P")
                .setServiceType("1.1")
                .build();
        Line actual = records.get(0);
        Assert.assertEquals(expected.getType(), actual.getType());
        Assert.assertTrue(expected.getDate().isEqual(actual.getDate()));
        Assert.assertEquals(expected.getQuestionType(), actual.getQuestionType());
    }

    @Test(expected = NullPointerException.class)
    public void checkParserWithNullData() {
        parserService.parseLines(null);
    }
}
