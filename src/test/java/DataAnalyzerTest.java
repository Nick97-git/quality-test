import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import service.FileService;
import service.LineService;
import service.ParserService;
import service.impl.FileServiceImpl;
import service.impl.LineServiceImpl;
import service.impl.ParserServiceImpl;

public class DataAnalyzerTest {
    private static final String PATH_TO_FILE_WITH_INPUT_DATA = "src/test/resources/testFile.txt";
    private static final String PATH_TO_EMPTY_FILE = "src/test/resources/emptyFile.txt";
    private static final String PATH_TO_DIRECTORY_WITH_OUTPUT_DATA = "src/test/resources/output";
    private static final String PATH_TO_FILE_WITH_OUTPUT_DATA =
            "src/test/resources/output/output.txt";
    private final FileService fileService = new FileServiceImpl();
    private final ParserService parserService = new ParserServiceImpl();
    private final LineService lineService = new LineServiceImpl();
    private final DataAnalyzer dataAnalyzer = new DataAnalyzer(fileService,
            parserService, lineService);

    @Test
    public void checkEvaluationOfDataOk() {
        dataAnalyzer.evaluateData(PATH_TO_FILE_WITH_INPUT_DATA, PATH_TO_DIRECTORY_WITH_OUTPUT_DATA);
        List<String> expected = List.of("83", "100", "-");
        List<String> actual = fileService.readFromFile(PATH_TO_FILE_WITH_OUTPUT_DATA);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkEvaluationOfDataWithEmptyFile() {
        dataAnalyzer.evaluateData(PATH_TO_EMPTY_FILE,
                PATH_TO_DIRECTORY_WITH_OUTPUT_DATA);
        List<String> outputData = fileService.readFromFile(PATH_TO_FILE_WITH_OUTPUT_DATA);
        Assert.assertTrue(outputData.isEmpty());
    }
}
