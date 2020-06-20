package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    @Test
    public void whenSadMessage_shouldReturnSad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("this is sad message");
        Assert.assertEquals("SAD",moodAnalyzer.analyzeMood());
    }

    @Test
    public void whenHappyMessage_shouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("this is happy message");
        Assert.assertEquals("HAPPY",moodAnalyzer.analyzeMood());
    }

    @Test
    public void whenNullMessage_shouldReturnNullException() {
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        }catch (MoodAnalysisException ex){
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_NULL,ex.exceptionType);
        }
    }

    @Test
    public void whenEmptyMessage_shouldReturnException() {
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer("");
        } catch (MoodAnalysisException ex) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_EMPTY,ex.exceptionType);
        }
    }
}
