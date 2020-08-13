package model.builder;

import java.time.LocalDate;
import model.Line;

public class WaitingTimeLineBuilder extends LineBuilder {
    private static final int WAITING_TIME_INDEX = 5;

    @Override
    public Line buildLine(String[] splitedLine) {
        return buildBase(splitedLine)
                .setWaitingTime(Integer.parseInt(splitedLine[WAITING_TIME_INDEX]))
                .setDate(LocalDate.parse(splitedLine[getDateIndex()], getFormatter()))
                .build();
    }
}
