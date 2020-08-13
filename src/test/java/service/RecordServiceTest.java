package service;

import java.util.List;
import model.Record;
import org.junit.Assert;
import org.junit.Test;
import service.impl.FileServiceImpl;
import service.impl.ParserServiceImpl;
import service.impl.RecordServiceImpl;

public class RecordServiceTest {
    private final FileService fileService = new FileServiceImpl();
    private final ParserService parserService = new ParserServiceImpl();
    private final RecordService recordService = new RecordServiceImpl();

    @Test
    public void checkDataOk() {
        List<String> data = getData("src/test/resources/testFile.txt");
        Assert.assertEquals(3, data.size());
    }

    @Test
    public void checkDataOnlyWithCRecords() {
        List<String> data = getData("src/test/resources/fileWithCRecords.txt");
        Assert.assertEquals(0, data.size());
    }

    @Test
    public void checkDataOnlyWithDRecords() {
        List<String> data = getData("src/test/resources/fileWithDRecords.txt");
        Assert.assertEquals(3, data.size());
        for (String line : data) {
            Assert.assertEquals("-", line);
        }
    }

    private List<String> getData(String path) {
        List<String> lines = fileService.readFromFile(path);
        List<Record> records = parserService.parseLines(lines);
        return recordService.getListOfAverageTime(records);
    }
}
