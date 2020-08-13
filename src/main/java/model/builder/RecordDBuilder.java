package model.builder;

import java.time.LocalDate;
import model.Record;

public class RecordDBuilder extends RecordBuilder {

    @Override
    public Record buildRecord(String[] splitedLine) {
        Record.Builder builder = buildBase(splitedLine);
        if (splitedLine[getDateIndex()].contains("-")) {
            String[] splitedData = splitedLine[getDateIndex()].split("-");
            builder.setDateFrom(LocalDate.parse(splitedData[0], getFormatter()))
                    .setDateTo(LocalDate.parse(splitedData[1], getFormatter()));
        } else {
            builder.setDateFrom(LocalDate.parse(splitedLine[getDateIndex()], getFormatter()));
        }
        return builder.build();
    }
}
