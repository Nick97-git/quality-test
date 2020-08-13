package service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Record;
import service.RecordService;

public class RecordServiceImpl implements RecordService {
    private static final String D_TYPE = "D";
    private static final String C_TYPE = "C";
    private static final String NO_VALID_C_RECORDS = "-";
    private static final String ANY_TYPE = "*";

    @Override
    public List<String> getListOfAverageTime(List<Record> records) {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < records.size(); i++) {
            Record record = records.get(i);
            if (record.getType().equals(D_TYPE)) {
                data.add(getTime(records.subList(0, i), record));
            }
        }
        return data;
    }

    private String getTime(List<Record> records, Record recordD) {
        int[] waitingTimes = records.stream()
                .filter(record -> record.getType().equals(C_TYPE))
                .filter(record -> record.getResponseType().equals(recordD.getResponseType()))
                .filter(record -> isValidType(record.getServiceType(), recordD.getServiceType()))
                .filter(record -> isValidType(record.getQuestionType(), recordD.getQuestionType()))
                .filter(record -> isValidDate(record.getDate(), recordD))
                .mapToInt(Record::getWaitingTime).toArray();
        int sum = Arrays.stream(waitingTimes).sum();
        return waitingTimes.length == 0
                ? NO_VALID_C_RECORDS
                : String.valueOf(sum / waitingTimes.length);
    }

    private boolean isValidDate(LocalDate recordCDate, Record recordD) {
        boolean isDateFrom = recordCDate.isEqual(recordD.getDateFrom())
                || recordCDate.isAfter(recordD.getDateFrom());
        return recordD.getDateTo().isEmpty()
                ? isDateFrom
                : isDateFrom
                && (recordCDate.isEqual(recordD.getDateTo().get())
                || recordCDate.isBefore(recordD.getDateTo().get()));
    }

    private boolean isValidType(String typeOfC, String typeOfD) {
        return typeOfD.equals(ANY_TYPE) || typeOfC.startsWith(typeOfD);
    }
}
