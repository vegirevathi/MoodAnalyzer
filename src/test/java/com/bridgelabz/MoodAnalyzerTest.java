package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    @Test
    public void whenSadMessage_shouldReturnSad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String mood = moodAnalyzer.analyzeMood("this is sad message");
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void whenHappyMessage_shouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String mood = moodAnalyzer.analyzeMood("this is happy message");
        Assert.assertEquals("HAPPY",mood);
    }
}
