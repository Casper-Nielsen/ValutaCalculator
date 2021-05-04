package com.example.valutacalculator;

/**
 * This interface is for converting Valuta from one type to another
 *
 *@author CKN
 *@version 1.0
 *@since 1.0
 */
public interface ValutaConverter {
    void setFromValue(double value);
    void setToValue(double value);
    double convert(double value);
}
