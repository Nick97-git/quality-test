package model;

import model.builder.RecordCBuilder;
import model.builder.RecordDBuilder;

public enum RecordType {
    C {
        @Override
        public Record getRecord(String[] splitedLine) {
            return new RecordCBuilder().buildRecord(splitedLine);
        }
    },
    D {
        @Override
        public Record getRecord(String[] splitedLine) {
            return new RecordDBuilder().buildRecord(splitedLine);
        }
    };

    public abstract Record getRecord(String[] splitedLine);
}
