package service;

import java.util.List;
import model.Line;

public interface ParserService {

    List<Line> parseLines(List<String> inputData);
}
