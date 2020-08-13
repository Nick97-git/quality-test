import java.util.List;
import model.Line;
import service.FileService;
import service.LineService;
import service.ParserService;

public class DataAnalyzer {
    private final FileService fileService;
    private final ParserService parserService;
    private final LineService lineService;

    public DataAnalyzer(FileService fileService,
                        ParserService parserService,
                        LineService lineService) {
        this.fileService = fileService;
        this.parserService = parserService;
        this.lineService = lineService;
    }

    public void evaluateData(String pathToFileWithInputData, String pathToDirectoryWithOutputData) {
        List<String> inputData = fileService.readFromFile(pathToFileWithInputData);
        List<Line> lines = parserService.parseLines(inputData);
        List<String> averageTimes = lineService.getAverageTimes(lines);
        fileService.writeToFile(pathToDirectoryWithOutputData, averageTimes);
    }
}
