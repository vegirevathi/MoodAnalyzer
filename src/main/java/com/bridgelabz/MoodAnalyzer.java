package com.bridgelabz;

import javax.lang.model.util.Types;

public class MoodAnalyzer {

    private String message;

    public MoodAnalyzer() {
    }

    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public String analyzeMood() {
    if(message.contains("sad"))
        return "SAD";
    else
        return "HAPPY";
    }
}
