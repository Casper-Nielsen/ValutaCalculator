package com.example.valutacalculator;


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
    private View view;
    private double value;
    private Valuta valuta;
    private ValutaStatusGetter valutaStatusGetter;


    private Valuta getValuta(){

        if (valuta == null){
            valuta = valutaStatusGetter.getStatus();
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
        this.valutaStatusGetter = new LocalValutaGetter();
        this.converter = new ValutaCalculator();
    }

    /**
     * Method that sets the input Valuta type
     *
     *@version 1.0
     *@since 1.0
     *@param valutaType the new Valuta that will be converted from
     */
    public void changeSelectedInput(String valutaType){
        converter.setFromValue(getValuta().rates.get(valutaType));
        view.onConvertedValueUpdate(converter.convert(value));
    }

    /**
     * Method that sets the output Valuta type
     *
     *@version 1.0
     *@since 1.0
     *@param valutaType the new Valuta that will be converted to
     */
    public void changeSelectedOutput(String valutaType){
        converter.setToValue(getValuta().rates.get(valutaType));
        view.onConvertedValueUpdate(converter.convert(value));
    }

    /**
     * Method that converts the input to the new valutatype
     *
     *@version 1.0
     *@since 1.0
     *@param input the value that will be converted
     */
    public void onInputChanged(double input){
        value = input;
        view.onConvertedValueUpdate(converter.convert(value));
    }

    /**
     * This interface is to be able to be controlled by the presenter
     *
     *@author CKN
     *@version 1.0
     *@since 1.0
     */
    interface View{
        void onConvertedValueUpdate(double value);
    }
}
