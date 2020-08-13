package service;

import java.util.List;
import model.Record;

public interface ParserService {

    List<Record> parseLines(List<String> lines);
}
