package service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Line;
import service.LineService;

public class LineServiceImpl implements LineService {
    private static final String QUERY_TYPE = "D";
    private static final String WAITING_TIME_TYPE = "C";
    private static final String NO_VALID_C_LINES = "-";
    private static final String ANY_TYPE = "*";

    @Override
    public List<String> getAverageTimes(List<Line> lines) {
        List<String> averageTimes = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            Line line = lines.get(i);
            if (line.getType().equals(QUERY_TYPE)) {
                averageTimes.add(getAverageTime(lines.subList(0, i), line));
            }
        }
        return averageTimes;
    }

    private String getAverageTime(List<Line> lines, Line queryLine) {
        int[] waitingTimes = lines.stream()
                .filter(record -> record.getType().equals(WAITING_TIME_TYPE))
                .filter(record -> record.getResponseType().equals(queryLine.getResponseType()))
                .filter(record -> isValidType(record.getServiceType(), queryLine.getServiceType()))
                .filter(record -> isValidType(record.getQuestionType(),
                        queryLine.getQuestionType()))
                .filter(record -> isValidDate(record.getDate(), queryLine))
                .mapToInt(Line::getWaitingTime).toArray();
        int sum = Arrays.stream(waitingTimes).sum();
        return waitingTimes.length == 0
                ? NO_VALID_C_LINES
                : String.valueOf(sum / waitingTimes.length);
    }

    private boolean isValidDate(LocalDate waitingTimeLineDate, Line queryLine) {
        boolean isDateFrom = waitingTimeLineDate.isEqual(queryLine.getDateFrom())
                || waitingTimeLineDate.isAfter(queryLine.getDateFrom());
        return queryLine.getDateTo().isEmpty()
                ? isDateFrom
                : isDateFrom
                && (waitingTimeLineDate.isEqual(queryLine.getDateTo().get())
                || waitingTimeLineDate.isBefore(queryLine.getDateTo().get()));
    }

    private boolean isValidType(String waitingTimeLineType, String queryType) {
        return queryType.equals(ANY_TYPE) || waitingTimeLineType.startsWith(queryType);
    }
}
