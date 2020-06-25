package com.bridgelabz;

public class MoodAnalyzer {

    private String message;

    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public String analyzeMood(String message) throws MoodAnalysisException {
        this.message = message;
        return analyzeMood();
    }

    public String analyzeMood() throws MoodAnalysisException{
        try {
            if (message.length()==0)
                throw new MoodAnalysisException("Enter proper message for empty string",MoodAnalysisException.ExceptionType.ENTERED_EMPTY);
            if (message.contains("sad"))
                return "SAD";
            else
                return "HAPPY";
        } catch (NullPointerException ex) {
            throw new MoodAnalysisException("Enter proper message for null",MoodAnalysisException.ExceptionType.ENTERED_NULL);
        }
    }
}
