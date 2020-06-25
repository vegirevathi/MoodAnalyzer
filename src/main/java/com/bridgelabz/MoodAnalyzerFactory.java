package com.bridgelabz;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {

    public static MoodAnalyzer createMoodAnalyzer(String... message) {
        try {
            Class<?> moodAnalyzerClass = Class.forName("com.bridgelabz.MoodAnalyzer");
            if (message.length == 0) {
                Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor();
                Object moodObject = moodConstructor.newInstance();
                return (MoodAnalyzer) moodObject;
            } else {
                Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor(String.class);
                Object moodObject = moodConstructor.newInstance(message);
                return (MoodAnalyzer) moodObject;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
