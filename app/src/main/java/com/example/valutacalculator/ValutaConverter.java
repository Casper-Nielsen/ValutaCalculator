package com.example.valutacalculator;

/**
 * This interface is for converting Valuta from one type to another
 *
 *@author CKN
 *@version 1.1
 *@since 1.0
 */
public interface ValutaConverter {
    ConvertedValuta convert(ConvertedValuta value);
}
