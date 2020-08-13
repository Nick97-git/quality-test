package model;

import model.builder.QueryLineBuilder;
import model.builder.WaitingTimeLineBuilder;

public enum LineType {
    C {
        @Override
        public Line getLine(String[] splitedLine) {
            return new WaitingTimeLineBuilder().buildLine(splitedLine);
        }
    },
    D {
        @Override
        public Line getLine(String[] splitedLine) {
            return new QueryLineBuilder().buildLine(splitedLine);
        }
    };

    public abstract Line getLine(String[] splitedLine);
}
