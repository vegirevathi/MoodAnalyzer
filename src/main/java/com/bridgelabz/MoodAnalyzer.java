package com.bridgelabz;

import javax.lang.model.util.Types;
import java.io.IOException;

public class MoodAnalyzer {

    private String message;

    public MoodAnalyzer() {
    }

    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public String analyzeMood() {
        try {
            if (message.contains("sad"))
                return "SAD";
            else
                return "HAPPY";
        } catch (NullPointerException ex) {
            return "HAPPY";
        }
    }
}
