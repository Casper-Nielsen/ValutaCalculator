package com.example.valutacalculator;


import android.content.Context;

import java.util.List;

/**
 * This class is a presenter
 * for the Valuta converter
 *
 * @author CKN
 * @version 1.2
 * @since 1.0
 */
public class ValutaConverterPresenter {
    private ValutaCalculator converter;
    private List<ConvertedValuta> history;
    private ConvertedValuta current;
    private View view;
    private double value;
    private Valuta valuta;
    private CurrencyDAO<Valuta> currency;
    private DataManagerDAO dataManager;


    private Valuta getValuta(){

        if (valuta == null){
            valuta = currency.getRates();
        }
        return valuta;
    }

    /**
     * Constructor that sets the view
     *
     *@version 1.0
     *@since 1.0
     *@param view is the view that will be controlled
     */
    public ValutaConverterPresenter(View view, Context context){
        this.view = view;
        this.currency = new LocalCurrency();
        this.converter = new ValutaCalculator();
        this.current = new ConvertedValuta();
        this.dataManager = new DataBaseManager(context);
    }

    /**
     * Method to get the history
     *
     *@version 1.2
     *@since 1.2
     */
    public List<ConvertedValuta> getHistory(){
        return dataManager.getHistory();
    }

    /**
     * Method to clear the history
     *
     *@version 1.2
     *@since 1.2
     */
    public void DeleteHistory(){
        dataManager.clearHistory();
    }

    /**
     * Method that sets the input Valuta type
     *
     *@version 1.1
     *@since 1.0
     *@param valutaType the new Valuta that will be converted from
     */
    public void changeSelectedInput(String valutaType){
        current.setFromValutaDouble(getValuta().rates.get(valutaType));
        current.setFromValuta(valutaType);
    }

    /**
     * Method that sets the output Valuta type
     *
     *@version 1.1
     *@since 1.0
     *@param valutaType the new Valuta that will be converted to
     */
    public void changeSelectedOutput(String valutaType){
        current.setToValutaDouble(getValuta().rates.get(valutaType));
        current.setToValuta(valutaType);
    }

    /**
     * Method that converts the input to the new valutatype
     *
     *@version 1.1
     *@since 1.1
     *@param input the value that will be converted
     */
    public void convertValue(double input){
        current.setFromValue(input);
        current = converter.convert(current);
        view.onConvertedValueUpdate(current);
        dataManager.addHistory(current);
    }

    /**
     * This interface is to be able to be controlled by the presenter
     *
     *@author CKN
     *@version 1.0
     *@since 1.0
     */
    interface View{
        void onConvertedValueUpdate(ConvertedValuta value);
    }
}
