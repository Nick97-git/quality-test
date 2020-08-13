import java.util.List;
import model.Record;
import service.FileService;
import service.ParserService;
import service.RecordService;

public class DataAnalyzer {
    private final FileService fileService;
    private final ParserService parserService;
    private final RecordService recordService;

    public DataAnalyzer(FileService fileService,
                        ParserService parserService,
                        RecordService recordService) {
        this.fileService = fileService;
        this.parserService = parserService;
        this.recordService = recordService;
    }

    public void evaluateData(String pathToFileWithInputData, String pathToDirectoryWithOutputData) {
        List<String> lines = fileService.readFromFile(pathToFileWithInputData);
        List<Record> records = parserService.parseLines(lines);
        List<String> data = recordService.getListOfAverageTime(records);
        fileService.writeToFile(pathToDirectoryWithOutputData, data);
    }
}
