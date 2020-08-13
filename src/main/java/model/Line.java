package model;

import java.time.LocalDate;
import java.util.Optional;

public class Line {
    private String type;
    private String serviceType;
    private String questionType;
    private String responseType;
    private LocalDate date;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private int waitingTime;

    private Line() {

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

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public Optional<LocalDate> getDateTo() {
        return Optional.ofNullable(dateTo);
    }

    public static Builder newBuilder() {
        return new Line().new Builder();
    }

    public class Builder {

        private Builder() {

        }

        public Builder setType(String type) {
            Line.this.type = type;
            return this;
        }

        public Builder setServiceType(String serviceType) {
            Line.this.serviceType = serviceType;
            return this;
        }

        public Builder setQuestionType(String questionType) {
            Line.this.questionType = questionType;
            return this;
        }

        public Builder setResponseType(String responseType) {
            Line.this.responseType = responseType;
            return this;
        }

        public Builder setDate(LocalDate date) {
            Line.this.date = date;
            return this;
        }

        public Builder setDateFrom(LocalDate dateFrom) {
            Line.this.dateFrom = dateFrom;
            return this;
        }

        public Builder setDateTo(LocalDate dateTo) {
            Line.this.dateTo = dateTo;
            return this;
        }

        public Builder setWaitingTime(int waitingTime) {
            Line.this.waitingTime = waitingTime;
            return this;
        }

        public Line build() {
            return Line.this;
        }
    }
}
