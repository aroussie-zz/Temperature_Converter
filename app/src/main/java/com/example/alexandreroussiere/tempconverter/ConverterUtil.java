package com.example.alexandreroussiere.tempconverter;

/**
 * Created by Alexandre Roussière on 21/01/2016.
 */
public class ConverterUtil {
    /**
     * Converts to Celcius
     * @param fahrenheit
     * @return
     */
    public static double convertFahrenheitToCelsius(float fahrenheit){
        return ((fahrenheit - 32) * 5.0 / 9.0);
    }

    /**
     * Converts to fahrenheit
     * @param celsius
     * @return
     */
    public static double convertCelsiusToFahrenheit(float celsius){
        return (celsius * (9 / 5.0)) + 32;
    }
}
