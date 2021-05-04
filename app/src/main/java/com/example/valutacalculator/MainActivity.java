package com.example.valutacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Activity for loading layout resources
 *
 * This activity is used to display the value calculators layout
 *
 *@author CKN
 *@version 1.0
 *@since 1.0
 */
public class MainActivity extends AppCompatActivity implements SpinnerListener.SelectedItemListener, ValutaConverterPresenter.View {
    private ArrayAdapter<CharSequence> adapter;
    private SpinnerListener fromSpinner;
    private SpinnerListener toSpinner;
    private ValutaConverterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fromSpinner = new SpinnerListener(this,1);
        toSpinner = new SpinnerListener(this,2);
        presenter = new ValutaConverterPresenter(this);
        // Start listening to editText on text changed
        ((EditText)findViewById(R.id.editTextNumberDecimal)).addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() != 0)
                    presenter.onInputChanged(Double.parseDouble(s.toString()));
                else
                    presenter.onInputChanged(0);

            }
        });
        setAdapter();
    }

    /**
     * Method that sets the adapter
     *
     *@version 1.0
     *@since 1.0
     */
    private void setAdapter(){
        adapter = ArrayAdapter.createFromResource(this,R.array.values_array,R.layout.support_simple_spinner_dropdown_item);

        // Gives the adapter to the first spinner
        Spinner fromSpinner = findViewById(R.id.from_value_Spinner);
        fromSpinner.setAdapter(adapter);
        // Sets it to DKK
        fromSpinner.setSelection(40);
        fromSpinner.setOnItemSelectedListener(this.fromSpinner);

        // Gives the adapter to the second spinner
        Spinner toSpinner = findViewById(R.id.to_value_Spinner);
        toSpinner.setAdapter(adapter);
        // Sets it to EUR
        toSpinner.setSelection(46);
        toSpinner.setOnItemSelectedListener(this.toSpinner);
    }

    /**
     * Method that sets the sets the valuta type
     *
     *@version 1.0
     *@since 1.0
     *@param value the value type
     *@param id the identifier between 1-2
     */
    @Override
    public void onItemSelected(String value, int id) {
        if (id == 1){
            presenter.changeSelectedInput(value);
        }else if(id == 2){
            presenter.changeSelectedOutput(value);
        }
    }

    /**
     * Method that shows the value
     *
     *@version 1.0
     *@since 1.0
     *@param value the value that will be shown
     */
    @Override
    public void onConvertedValueUpdate(double value) {
        ((EditText)findViewById(R.id.output_editTextNumberDecimal)).setText(String.format("%.2f", value));
    }
}