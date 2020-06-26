package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerTest {

    private Object message;

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
    public void givenMoodAnalyzerClass_whenProper_shouldReturnObject() {
        try {
            Class<?> moodAnalyzerClass = Class.forName("com.bridgelabz.MoodAnalyzer");
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor(String.class);
            Object moodObject = moodConstructor.newInstance(message);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (MoodAnalysisException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzerClass_whenNotProper_shouldThrowException() {
        try {
            Class<?> moodAnalyzerClass = Class.forName("com.bridgelabz.MoodAnalyzerWrong");
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor(String.class);
            Object moodObject = moodConstructor.newInstance(message);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (MoodAnalysisException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzerConstructor_whenNotProper_shouldThrowException() {
        try {
            Class<?> moodAnalyzerClass = Class.forName("com.bridgelabz.MoodAnalyzer");
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor(String.class);
            Object moodObject = moodConstructor.newInstance(message);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (MoodAnalysisException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzerClass_NoParameters_whenProper_shouldReturnObject() {
        try {
            Class<?> moodAnalyzerClass = Class.forName("com.bridgelabz.MoodAnalyzer");
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor();
            Object moodObject = moodConstructor.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (MoodAnalysisException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzerClass_NoParameters_whenNotProper_shouldThrowException() {
        try {
            Class<?> moodAnalyzerClass = Class.forName("com.bridgelabz.MoodAnalyzerWrong");
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor();
            Object moodObject = moodConstructor.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (MoodAnalysisException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzerConstructor_NoParameters_whenNotProper_shouldThrowException() {
        try {
            Class<?> moodAnalyzerClass = Class.forName("com.bridgelabz.MoodAnalyzer");
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor(String.class);
            Object moodObject = moodConstructor.newInstance(message);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (MoodAnalysisException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzer_withReflector_shouldReturnHappy() {
        try {
            Object myObject = MoodAnalyzerReflector.createMoodAnalyzer("I am in Happy Mood");
            Object mood = MoodAnalyzerReflector.invokeMethod(myObject, "analyzeMood");
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzer_withReflector_whenImproper_shouldThrowException() {
        try {
            Object myObject = MoodAnalyzerReflector.createMoodAnalyzer("I am in Happy Mood");
            Object mood = MoodAnalyzerReflector.invokeMethod(myObject, "analyzeMoodWrong");
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzer_changeMood_shouldReturnHappy() {
        try {
            Object myObject = MoodAnalyzerReflector.createMoodAnalyzer("");
            MoodAnalyzerReflector.setFieldValue(myObject, "message", "I am in Happy Mood");
            Object mood = MoodAnalyzerReflector.invokeMethod(myObject, "analyzeMood");
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzer_changeMood_shouldThrowEXception_whenImproperFieldValue() {
        try {
            Object myObject = MoodAnalyzerReflector.createMoodAnalyzer("");
            MoodAnalyzerReflector.setFieldValue(myObject, "message", "I am in Sad Mood");
            Object mood = MoodAnalyzerReflector.invokeMethod(myObject, "analyzeMood");
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzer_changeMood_shouldThrowEXception_whenNullFieldValue() {
        try {
            Object myObject = MoodAnalyzerReflector.createMoodAnalyzer("");
            MoodAnalyzerReflector.setFieldValue(myObject, "message", "");
            Object mood = MoodAnalyzerReflector.invokeMethod(myObject, "analyzeMood");
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }
}