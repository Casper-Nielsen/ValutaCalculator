package com.example.valutacalculator;

import android.view.View;
import android.widget.AdapterView;

/**
 * This class that gets the selected item from a spinner
 *
 *@author CKN
 *@version 1.0
 *@since 1.0
 */
public class SpinnerListener implements AdapterView.OnItemSelectedListener {
    private SelectedItemListener listener;
    private int id;

    /**
     * Constructor that sets the listener
     *
     *@version 1.0
     *@since 1.0
     *@param listener that will get called when a item is selected
     *@param id the identifier
     */
    public SpinnerListener(SelectedItemListener listener, int id){
        this.listener = listener;
        this.id = id;
    }

    /**
     * Method that gets the selected item and sends it to the listener
     *
     *@version 1.0
     *@since 1.0
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        listener.onItemSelected((String)parent.getSelectedItem(),this.id);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    /**
     * This interface is to be able to be controlled by the presenter
     *
     *@author CKN
     *@version 1.0
     *@since 1.0
     */
    public interface SelectedItemListener {
        void onItemSelected(String value, int id);
    }
}
