package com.example.valutacalculator;

/**
 * This class converts from one value to another
 *
 * @author CKN
 * @version 1.2
 * @since 1.0
 */
public class ValutaCalculator {
    private double fromValue;
    private double toValue;

    public void setFromValue(double value){
        fromValue = value;
    }
    public void setToValue(double value){
        toValue = value;
    }

    /**
     * Method that converts the value
     *
     * @version 1.0
     * @since 1.0
     * @param value the value that will be converted
     * @return the converted value
     */
    public double convert(double value){
        double commonValue = value/fromValue;
        return commonValue*toValue;
    }
}
