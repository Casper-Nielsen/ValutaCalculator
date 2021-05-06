package com.example.valutacalculator;

/**
 * This class converts from one value to another
 *
 * @author CKN
 * @version 1.1
 * @since 1.0
 */
public class ValutaCalculator implements ValutaConverter {

    /**
     * Method that converts the value
     *
     * @version 1.1
     * @since 1.1
     * @param value the value that will be converted
     * @return the converted value
     */
    private double calculate(double value, double fromValuta, double toValuta){
        double commonValue = value/fromValuta;
        return commonValue*toValuta;
    }

    /**
     * Method that converts the value
     *
     * @version 1.1
     * @since 1.0
     * @param value the valuta object that will have its value converted
     * @return the converted value
     */
    @Override
    public ConvertedValuta convert(ConvertedValuta value) {
        value.setToValue(calculate(value.getFromValue(),value.getFromValutaDouble(),value.getToValutaDouble()));
        return value;
    }
}
