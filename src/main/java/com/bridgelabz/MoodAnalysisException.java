package com.bridgelabz;

public class MoodAnalysisException extends RuntimeException {

    public enum ExceptionType {
        ENTERED_NULL, ENTERED_EMPTY, NO_SUCH_METHOD, NO_SUCH_CLASS, NO_SUCH_FIELD, NO_ACCESS_GIVEN;
    }

    ExceptionType exceptionType;

    public MoodAnalysisException(String message, ExceptionType exceptionType) {
        super(message);
        this.exceptionType = exceptionType;
    }
}
