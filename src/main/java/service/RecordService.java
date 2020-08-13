package service;

import java.util.List;
import model.Record;

public interface RecordService {

    List<String> getListOfAverageTime(List<Record> records);
}
