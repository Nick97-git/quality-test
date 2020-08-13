package service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.log4j.Logger;
import service.FileService;

public class FileServiceImpl implements FileService {
    private static final Logger LOGGER = Logger.getLogger(FileServiceImpl.class);
    private static final String FILE_NAME = "output.txt";

    public List<String> readFromFile(String path) {
        File file = new File(path);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            List<String> lines = bufferedReader.lines().collect(Collectors.toList());
            LOGGER.info("File has been read!");
            return lines;
        } catch (IOException e) {
            throw new RuntimeException("Reading of file has been failed!", e);
        }
    }

    @Override
    public void writeToFile(String directoryPath, List<String> data) {
        Path pathToDirectory = Paths.get(directoryPath);
        Path pathToFile = Paths.get(directoryPath + "/" + FILE_NAME);
        try {
            if (!Files.exists(pathToFile)) {
                Files.createDirectory(pathToDirectory);
                Files.createFile(pathToFile);
            }
            Files.write(pathToFile, String.join("\n", data).getBytes());
            LOGGER.info("File has been successfully written!");
        } catch (IOException e) {
            throw new RuntimeException("Write to file has failed!", e);
        }
    }
}
