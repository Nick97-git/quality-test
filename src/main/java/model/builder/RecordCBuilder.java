package model.builder;

import java.time.LocalDate;
import model.Record;

public class RecordCBuilder extends RecordBuilder {
    private static final int WAITING_TIME = 5;

    @Override
    public Record buildRecord(String[] splitedLine) {
        return buildBase(splitedLine)
                .setWaitingTime(Integer.parseInt(splitedLine[WAITING_TIME]))
                .setDate(LocalDate.parse(splitedLine[getDateIndex()], getFormatter()))
                .build();
    }
}
