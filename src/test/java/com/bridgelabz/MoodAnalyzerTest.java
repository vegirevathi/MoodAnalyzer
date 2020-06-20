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
}
