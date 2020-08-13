package service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Line;
import model.LineType;
import org.apache.log4j.Logger;
import service.ParserService;

public class ParserServiceImpl implements ParserService {
    private static final Logger LOGGER = Logger.getLogger(ParserServiceImpl.class);
    private static final int LINE_TYPE_INDEX = 0;
    private static final int CAPACITY_INDEX = 0;

    @Override
    public List<Line> parseLines(List<String> inputData) {
        if (inputData.size() == 0) {
            return Collections.emptyList();
        }
        List<Line> lines = new ArrayList<>(Integer.parseInt(inputData.get(CAPACITY_INDEX)));
        for (int i = 1; i < inputData.size(); i++) {
            String[] splitedLine = inputData.get(i).split(" ");
            LineType lineType = LineType.valueOf(splitedLine[LINE_TYPE_INDEX]);
            lines.add(lineType.getLine(splitedLine));
        }
        LOGGER.info("Lines have been parsed!");
        return lines;
    }
}
