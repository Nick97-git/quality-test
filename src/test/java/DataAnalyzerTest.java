import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import service.FileService;
import service.ParserService;
import service.RecordService;
import service.impl.FileServiceImpl;
import service.impl.ParserServiceImpl;
import service.impl.RecordServiceImpl;

public class DataAnalyzerTest {
    private static final String PATH_TO_FILE_WITH_INPUT_DATA = "src/test/resources/testFile.txt";
    private static final String PATH_TO_FILE_WITH_EMPTY_INPUT_DATA =
            "src/test/resources/emptyFile.txt";
    private static final String PATH_TO_DIRECTORY_WITH_OUTPUT_DATA = "src/test/resources/output";
    private static final String PATH_TO_FILE_WITH_OUTPUT_DATA =
            "src/test/resources/output/output.txt";
    private final FileService fileService = new FileServiceImpl();
    private final ParserService parserService = new ParserServiceImpl();
    private final RecordService recordService = new RecordServiceImpl();
    private final DataAnalyzer dataAnalyzer = new DataAnalyzer(fileService,
            parserService, recordService);

    @Test
    public void checkEvaluationOfDataOk() {
        dataAnalyzer.evaluateData(PATH_TO_FILE_WITH_INPUT_DATA, PATH_TO_DIRECTORY_WITH_OUTPUT_DATA);
        List<String> expected = List.of("83", "100", "-");
        List<String> actual = fileService.readFromFile(PATH_TO_FILE_WITH_OUTPUT_DATA);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkEvaluationOfDataWithEmptyFile() {
        dataAnalyzer.evaluateData(PATH_TO_FILE_WITH_EMPTY_INPUT_DATA,
                PATH_TO_DIRECTORY_WITH_OUTPUT_DATA);
        List<String> lines = fileService.readFromFile(PATH_TO_FILE_WITH_OUTPUT_DATA);
        Assert.assertTrue(lines.isEmpty());
    }
}
