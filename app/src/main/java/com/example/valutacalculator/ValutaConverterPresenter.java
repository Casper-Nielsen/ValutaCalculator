package com.example.valutacalculator;


import java.util.List;

/**
 * This class is a presenter
 * for the Valuta converter
 *
 * @author CKN
 * @version 1.0
 * @since 1.0
 */
public class ValutaConverterPresenter {
    private ValutaCalculator converter;
    private List<ConvertedValuta> history;
    private ConvertedValuta current;
    private View view;
    private double value;
    private Valuta valuta;
    private CurrencyDAO<Valuta> currencyDAO;


    private Valuta getValuta(){

        if (valuta == null){
            valuta = currencyDAO.getRates();
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
    public  ValutaConverterPresenter(View view){
        this.view = view;
        this.currencyDAO = new LocalCurrency();
        this.converter = new ValutaCalculator();
        this.current = new ConvertedValuta();
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
        view.onConvertedValueUpdate(converter.convert(current));
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
