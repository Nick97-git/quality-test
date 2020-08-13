package service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Record;
import model.RecordType;
import org.apache.log4j.Logger;
import service.ParserService;

public class ParserServiceImpl implements ParserService {
    private static final Logger LOGGER = Logger.getLogger(ParserServiceImpl.class);
    private static final int RECORD_TYPE = 0;

    @Override
    public List<Record> parseLines(List<String> lines) {
        if (lines.size() == 0) {
            return Collections.emptyList();
        }
        int initialCapacity = Integer.parseInt(lines.get(0));
        List<Record> records = new ArrayList<>(initialCapacity);
        for (int i = 1; i < lines.size(); i++) {
            String[] splitedLine = lines.get(i).split(" ");
            RecordType recordType = RecordType.valueOf(splitedLine[RECORD_TYPE]);
            records.add(recordType.getRecord(splitedLine));
        }
        LOGGER.info("Lines have been parsed!");
        return records;
    }
}
