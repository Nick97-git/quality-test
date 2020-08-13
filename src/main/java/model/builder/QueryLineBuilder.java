package model.builder;

import java.time.LocalDate;
import model.Line;

public class QueryLineBuilder extends LineBuilder {
    private static final int DATE_FROM_INDEX = 0;
    private static final int DATE_TO_INDEX = 1;

    @Override
    public Line buildLine(String[] splitedLine) {
        Line.Builder builder = buildBase(splitedLine);
        String date = splitedLine[getDateIndex()];
        if (date.contains("-")) {
            String[] splitedDate = date.split("-");
            builder.setDateFrom(LocalDate.parse(splitedDate[DATE_FROM_INDEX], getFormatter()))
                    .setDateTo(LocalDate.parse(splitedDate[DATE_TO_INDEX], getFormatter()));
        } else {
            builder.setDateFrom(LocalDate.parse(date, getFormatter()));
        }
        return builder.build();
    }
}
