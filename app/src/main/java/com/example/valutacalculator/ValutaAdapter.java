package com.example.valutacalculator;

import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is for showing the ConvertedValuta
 *
 *@author CKN
 *@version 1.2
 *@since 1.1
 */
public class ValutaAdapter extends ArrayAdapter<ConvertedValuta> {
    private Context mContext;
    private List<ConvertedValuta> convertedValutaList;

    public ValutaAdapter(@NonNull Context context, List<ConvertedValuta> list){
        super(context,0,list);
        mContext = context;
        convertedValutaList = list;
    }

    /**
     * Method creates the view for selected ConvertedValuta
     *
     *@version 1.1
     *@since 1.1
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.activity_listview,parent,false);

        ConvertedValuta current = convertedValutaList.get(position);
        TextView fromValuta = (TextView)listItem.findViewById(R.id.from_valuta);
        fromValuta.setText(current.getFromValuta());
        TextView fromValue = (TextView)listItem.findViewById(R.id.from_value);
        fromValue.setText(String.format("%.2f", current.getFromValue()));
        TextView toValuta = (TextView)listItem.findViewById(R.id.to_valuta);
        toValuta.setText(current.getToValuta());
        TextView toValue = (TextView)listItem.findViewById(R.id.to_value);
        toValue.setText(String.format("%.2f", current.getToValue()));
        TextView valuta = (TextView)listItem.findViewById(R.id.valuta);
        valuta.setText(String.format("%.5f", (current.getToValutaDouble()/current.getFromValutaDouble())));


        return listItem;
    }
}
