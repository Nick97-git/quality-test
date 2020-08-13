import service.impl.FileServiceImpl;
import service.impl.ParserServiceImpl;
import service.impl.RecordServiceImpl;

public class Main {
    private static final String PATH_TO_FILE_WITH_INPUT_DATA = "src/main/resources/file.txt";
    private static final String PATH_TO_DIRECTORY_WITH_OUTPUT_DATA = "output";

    public static void main(String[] args) {
        DataAnalyzer dataAnalyzer = new DataAnalyzer(new FileServiceImpl(),
                new ParserServiceImpl(),
                new RecordServiceImpl());
        dataAnalyzer.evaluateData(PATH_TO_FILE_WITH_INPUT_DATA, PATH_TO_DIRECTORY_WITH_OUTPUT_DATA);
    }
}
