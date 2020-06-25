package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerTest {

    @Test
    public void whenSadMessage_shouldReturnSad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("this is sad message");
        Assert.assertEquals("SAD", moodAnalyzer.analyzeMood());
    }

    @Test
    public void whenHappyMessage_shouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("this is happy message");
        Assert.assertEquals("HAPPY", moodAnalyzer.analyzeMood());
    }

    @Test
    public void whenNullMessage_shouldReturnNullException() {
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        } catch (MoodAnalysisException ex) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_NULL, ex.exceptionType);
        }
    }

    @Test
    public void whenEmptyMessage_shouldReturnEmptyException() {
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer("");
        } catch (MoodAnalysisException ex) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_EMPTY, ex.exceptionType);
        }
    }

    @Test
    public void givenMoodAnalyserObject_WhenProper_ShouldReturnObject() {
        Constructor<?> constructor = null;
        try {
            constructor = Class.forName("com.bridgelabz.MoodAnalyzer").getConstructor(String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            constructor.newInstance("I am in a Happy Mood");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzerClass_whenProper_shouldReturnObject() {
        MoodAnalyzer moodAnalyzer = MoodAnalyzerReflector.createMoodAnalyzer("I am in a Happy Mood");
        try {
            String mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzerClass_whenNotProper_shouldReturnObject() {
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerReflector.createMoodAnalyzer("I am in Happy Mood");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.exceptionType);
        }
    }

    @Test
    public void givenMoodAnalyzerConstructor_whenNotProper_shouldReturnObject() {
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerReflector.createMoodAnalyzer("I am in Happy Mood");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.exceptionType);
        }
    }

    @Test
    public void givenMoodAnalyzerClass_NoParameters_whenProper_shouldReturnObject() {
        MoodAnalyzer moodAnalyzer = MoodAnalyzerReflector.createMoodAnalyzer();
        try {
            String mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzerClass_NoParameters_whenNotProper_shouldReturnObject() {
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerReflector.createMoodAnalyzer();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.exceptionType);
        }
    }

    @Test
    public void givenMoodAnalyzerConstructor_NoParameters_whenNotProper_shouldReturnObject() {
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerReflector.createMoodAnalyzer();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.exceptionType);
        }
    }

    @Test
    public void givenMoodAnalyzer_withReflector_shouldReturnHappy() {
        try {
            Object myObject = MoodAnalyzerReflector.createMoodAnalyzer("I am in Happy Mood");
            Object mood = MoodAnalyzerReflector.invokeMethod(myObject, "analyzeMood");
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

}
