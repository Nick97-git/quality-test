package model.builder;

import java.time.format.DateTimeFormatter;
import model.Record;

public abstract class RecordBuilder {
    private static final int DATE = 4;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter
            .ofPattern("dd.MM.yyyy");
    private static final int QUESTION_TYPE = 2;
    private static final int RESPONSE_TYPE = 3;
    private static final int SERVICE_TYPE = 1;
    private static final int TYPE = 0;

    public abstract Record buildRecord(String[] splitedLine);

    protected DateTimeFormatter getFormatter() {
        return FORMATTER;
    }

    protected int getDateIndex() {
        return DATE;
    }

    protected Record.Builder buildBase(String[] splitedLine) {
        return Record.newBuilder()
                .setType(splitedLine[TYPE])
                .setServiceType(splitedLine[SERVICE_TYPE])
                .setQuestionType(splitedLine[QUESTION_TYPE])
                .setResponseType(splitedLine[RESPONSE_TYPE]);
    }
}
