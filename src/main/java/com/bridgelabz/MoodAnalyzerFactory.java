package com.bridgelabz;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {

    public static MoodAnalyzer createMoodAnalyzer(String message) {
        try {
            Class<?> moodAnalyzerClass = Class.forName("com.bridgelabz.MoodAnalyzer");
            try {
                Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor(String.class);
                try {
                    Object moodObj = moodConstructor.newInstance(message);
                    return (MoodAnalyzer) moodObj;
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
