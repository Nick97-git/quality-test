package model;

import java.time.LocalDate;
import java.util.Optional;

public class Record {
    private String type;
    private String serviceType;
    private String questionType;
    private String responseType;
    private LocalDate date;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private int waitingTime;

    private Record() {

    }

    public String getType() {
        return type;
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getQuestionType() {
        return questionType;
    }

    public String getResponseType() {
        return responseType;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public static Builder newBuilder() {
        return new Record().new Builder();
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public Optional<LocalDate> getDateTo() {
        return Optional.ofNullable(dateTo);
    }

    public class Builder {

        private Builder() {

        }

        public Builder setType(String type) {
            Record.this.type = type;
            return this;
        }

        public Builder setServiceType(String serviceType) {
            Record.this.serviceType = serviceType;
            return this;
        }

        public Builder setQuestionType(String questionType) {
            Record.this.questionType = questionType;
            return this;
        }

        public Builder setResponseType(String responseType) {
            Record.this.responseType = responseType;
            return this;
        }

        public Builder setDate(LocalDate date) {
            Record.this.date = date;
            return this;
        }

        public Builder setDateFrom(LocalDate dateFrom) {
            Record.this.dateFrom = dateFrom;
            return this;
        }

        public Builder setDateTo(LocalDate dateTo) {
            Record.this.dateTo = dateTo;
            return this;
        }

        public Builder setWaitingTime(int waitingTime) {
            Record.this.waitingTime = waitingTime;
            return this;
        }

        public Record build() {
            return Record.this;
        }
    }
}
