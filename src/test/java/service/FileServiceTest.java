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
    private final FileService fileService = new FileServiceImpl();
    private final List<String> data = List.of("1", "2", "3");

    @Test
    public void isReadFromFileOk() {
        List<String> lines = fileService.readFromFile("src/test/resources/testFile.txt");
        String expected = "7";
        String actual = lines.get(0);
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(8, lines.size());
    }

    @Test(expected = RuntimeException.class)
    public void isReadFromFileNotOk() {
        fileService.readFromFile("src/test/resources/fil.txt");
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
        fileService.writeToFile(DIRECTORY_PATH, data);
        Path pathToFile = Paths.get(DIRECTORY_PATH + "/output.txt");
        int expected = data.size();
        int actual = (int) Files.lines(pathToFile).count();
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void isWriteToFileNotOk() {
        fileService.writeToFile("", data);
    }
}
