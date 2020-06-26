package com.bridgelabz;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerReflector {

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
            throw new MoodAnalysisException("No such Class", MoodAnalysisException.ExceptionType.NO_SUCH_CLASS);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException("No such Method", MoodAnalysisException.ExceptionType.NO_SUCH_METHOD);
        }
        return null;
    }

    public static Object invokeMethod(Object myobject, String methodName) throws MoodAnalysisException {
        try {
            return myobject.getClass().getMethod(methodName).invoke(myobject);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException("No such Method", MoodAnalysisException.ExceptionType.NO_SUCH_METHOD);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setFieldValue(Object myObject, String fieldName, String fieldValue) throws MoodAnalysisException {
        try {
            Field field = myObject.getClass().getField(fieldName);
            field.setAccessible(true);
            field.set(myObject, fieldValue);
        } catch (NoSuchFieldException e) {
            throw new MoodAnalysisException("No such field", MoodAnalysisException.ExceptionType.NO_SUCH_FIELD);
        } catch (MoodAnalysisException e) {
            throw new MoodAnalysisException("Entered Null", MoodAnalysisException.ExceptionType.ENTERED_NULL);
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException("Not Accesible", MoodAnalysisException.ExceptionType.NO_ACCESS_GIVEN);
        }
    }
}
