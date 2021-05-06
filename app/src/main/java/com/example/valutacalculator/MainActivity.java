package com.example.valutacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

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
    private ValutaAdapter valutaAdapter;

    ArrayList<ConvertedValuta> ConvertedArray = new ArrayList<ConvertedValuta>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        fromSpinner = new SpinnerListener(this,1);
        toSpinner = new SpinnerListener(this,2);
        presenter = new ValutaConverterPresenter(this);
        setAdapter();

        valutaAdapter = new ValutaAdapter(this, ConvertedArray);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(valutaAdapter);
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
     * Method to Take input and convert to selected output
     *
     *@version 1.0
     *@since 1.0
     */
    public void onConvertButtonClicked(View view){
        String input =  ((EditText)findViewById(R.id.editTextNumberDecimal)).getText().toString();
        if(input.equals(""))
            input = "0";
        presenter.convertValue(Double.parseDouble(input));
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
    public void onConvertedValueUpdate(ConvertedValuta value) {
        ((EditText)findViewById(R.id.output_editTextNumberDecimal)).setText(String.format("%.2f", value.getToValue()));
        valutaAdapter.add(value.Copy());
        //valutaAdapter = new ValutaAdapter(this, mobileArray);


        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(valutaAdapter);

    }
}