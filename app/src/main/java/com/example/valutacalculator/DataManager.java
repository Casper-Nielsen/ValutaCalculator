package com.example.valutacalculator;

import java.util.List;

/**
 * This interface is for getting history
 *
 *@author CKN
 *@version 1.2
 *@since 1.2
 */
public interface DataManager {
    List<ConvertedValuta> getHistory();
    void addHistory(ConvertedValuta convertedValuta);
}
