package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import service.impl.FileServiceImpl;

public class FileServiceTest {
    private static final String DIRECTORY_PATH = "src/test/resources/output";
    private static final String PATH_TO_NON_EXISTENT_FILE = "src/test/resources/fil.txt";
    private static final String PATH_TO_TEST_FILE = "src/test/resources/testFile.txt";
    private static final String FILE_NAME = "output.txt";
    private final FileService fileService = new FileServiceImpl();
    private final List<String> inputData = List.of("1", "2", "3");

    @Test
    public void isReadFromFileOk() {
        List<String> inputData = fileService.readFromFile(PATH_TO_TEST_FILE);
        String expected = "7";
        String actual = inputData.get(0);
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(8, inputData.size());
    }

    @Test(expected = RuntimeException.class)
    public void isReadFromFileNotOk() {
        fileService.readFromFile(PATH_TO_NON_EXISTENT_FILE);
    }

    @Test(expected = NullPointerException.class)
    public void checkReadFromFileWithNull() {
        fileService.readFromFile(null);
    }

    @Test(expected = NullPointerException.class)
    public void checkWriteToFileWithNull() {
        fileService.writeToFile(null, null);
    }

    @Test
    public void isWriteToFileOk() throws IOException {
        fileService.writeToFile(DIRECTORY_PATH, inputData);
        Path pathToFile = Paths.get(DIRECTORY_PATH + "/" + FILE_NAME);
        int expected = inputData.size();
        int actual = (int) Files.lines(pathToFile).count();
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void isWriteToFileNotOk() {
        fileService.writeToFile("", inputData);
    }
}
