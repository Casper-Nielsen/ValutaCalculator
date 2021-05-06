package com.example.valutacalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is for managing the db and all that goes in and out of it
 *
 *@author CKN
 *@version 1.2
 *@since 1.2
 */
public class DataBaseManager implements DataManagerDAO {

    private HistoryReaderContract.HistoryReaderDbHelper dbHelper;
    private Context context;

    public DataBaseManager(Context context){
        this.context = context;
        this.dbHelper = new HistoryReaderContract.HistoryReaderDbHelper(context);
    }

    /**
     * Method for getting a list from the db
     *
     * @version 1.2
     * @since 1.2
     * @return list containing all conversions saved
     */
    @Override
    public List<ConvertedValuta> getHistory() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                HistoryReaderContract.HistoryEntry.COLUMN_NAME_FROM_VALUTA,
                HistoryReaderContract.HistoryEntry.COLUMN_NAME_FROM_VALUTA_RATE,
                HistoryReaderContract.HistoryEntry.COLUMN_NAME_FROM_VALUE,
                HistoryReaderContract.HistoryEntry.COLUMN_NAME_TO_VALUTA,
                HistoryReaderContract.HistoryEntry.COLUMN_NAME_TO_VALUTA_RATE,
                HistoryReaderContract.HistoryEntry.COLUMN_NAME_TO_VALUE
        };


        String sortOrder =
                HistoryReaderContract.HistoryEntry._ID + " DESC";

        Cursor cursor;
        try {
            // trys to get from the db
            cursor = db.query(
                    HistoryReaderContract.HistoryEntry.TABLE_NAME,
                    projection,
                    null,
                    null,
                    null,
                    null,
                    sortOrder
            );
        }catch (Exception e){
            // try and create db first then get from the db
            dbHelper.onCreate(db);
            cursor = db.query(
                    HistoryReaderContract.HistoryEntry.TABLE_NAME,
                    projection,
                    null,
                    null,
                    null,
                    null,
                    sortOrder
            );
        }

        // converting the sql response to list of convertedvaluta
        List<ConvertedValuta> items = new ArrayList<ConvertedValuta>();
        while(cursor.moveToNext()) {
            items.add(new ConvertedValuta(
                    cursor.getString(cursor.getColumnIndexOrThrow(HistoryReaderContract.HistoryEntry.COLUMN_NAME_FROM_VALUTA)),
                    cursor.getDouble(cursor.getColumnIndexOrThrow(HistoryReaderContract.HistoryEntry.COLUMN_NAME_FROM_VALUTA_RATE)),
                    cursor.getDouble(cursor.getColumnIndexOrThrow(HistoryReaderContract.HistoryEntry.COLUMN_NAME_FROM_VALUE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(HistoryReaderContract.HistoryEntry.COLUMN_NAME_TO_VALUTA)),
                    cursor.getDouble(cursor.getColumnIndexOrThrow(HistoryReaderContract.HistoryEntry.COLUMN_NAME_TO_VALUTA_RATE)),
                    cursor.getDouble(cursor.getColumnIndexOrThrow(HistoryReaderContract.HistoryEntry.COLUMN_NAME_TO_VALUE))
            ));
        }
        cursor.close();
        return items;
    }

    /**
     * Method for adding things into the db
     *
     *@version 1.2
     *@since 1.2
     *@param convertedValuta the value that will be added to the db
     */
    @Override
    public void addHistory(ConvertedValuta convertedValuta) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HistoryReaderContract.HistoryEntry.COLUMN_NAME_FROM_VALUTA,convertedValuta.getFromValuta());
        values.put(HistoryReaderContract.HistoryEntry.COLUMN_NAME_FROM_VALUTA_RATE,convertedValuta.getFromValutaDouble());
        values.put(HistoryReaderContract.HistoryEntry.COLUMN_NAME_FROM_VALUE,convertedValuta.getFromValue());
        values.put(HistoryReaderContract.HistoryEntry.COLUMN_NAME_TO_VALUTA,convertedValuta.getToValuta());
        values.put(HistoryReaderContract.HistoryEntry.COLUMN_NAME_TO_VALUE,convertedValuta.getToValue());
        values.put(HistoryReaderContract.HistoryEntry.COLUMN_NAME_TO_VALUTA_RATE,convertedValuta.getToValutaDouble());

        Log.d("test", "addHistory: " + values.toString());
        db.insert(HistoryReaderContract.HistoryEntry.TABLE_NAME,null,values);
    }

    /**
     * <p>Method to clear the db</p>
     * <p>by deleting it</p>
     *
     *@version 1.2
     *@since 1.2
     */
    @Override
    public void clearHistory() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        dbHelper.onUpgrade(db,0,0);
    }
}
