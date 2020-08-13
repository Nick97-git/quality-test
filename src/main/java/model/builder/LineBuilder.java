package model.builder;

import java.time.format.DateTimeFormatter;
import model.Line;

public abstract class LineBuilder {
    private static final int DATE_INDEX = 4;
    private static final int QUESTION_TYPE_INDEX = 2;
    private static final int RESPONSE_TYPE_INDEX = 3;
    private static final int SERVICE_TYPE_INDEX = 1;
    private static final int TYPE_INDEX = 0;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter
            .ofPattern("dd.MM.yyyy");

    public abstract Line buildLine(String[] splitedLine);

    protected DateTimeFormatter getFormatter() {
        return FORMATTER;
    }

    protected int getDateIndex() {
        return DATE_INDEX;
    }

    protected Line.Builder buildBase(String[] splitedLine) {
        return Line.newBuilder()
                .setType(splitedLine[TYPE_INDEX])
                .setServiceType(splitedLine[SERVICE_TYPE_INDEX])
                .setQuestionType(splitedLine[QUESTION_TYPE_INDEX])
                .setResponseType(splitedLine[RESPONSE_TYPE_INDEX]);
    }
}
