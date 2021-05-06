package com.example.valutacalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.List;

/**
 * This class is a Contract for the db
 *
 *@author CKN
 *@version 1.2
 *@since 1.2
 */
public final class HistoryReaderContract {
    private HistoryReaderContract(){}

    /**
     * This class contains the information about the db
     *
     *@author CKN
     *@version 1.2
     *@since 1.2
     */
    public static class HistoryEntry implements BaseColumns {
        public static final String TABLE_NAME = "Convection";
        public static final String COLUMN_NAME_FROM_VALUTA = "fValuta";
        public static final String COLUMN_NAME_FROM_VALUTA_RATE = "fValutaRate";
        public static final String COLUMN_NAME_FROM_VALUE = "fValue";
        public static final String COLUMN_NAME_TO_VALUTA = "tValuta";
        public static final String COLUMN_NAME_TO_VALUTA_RATE = "tValutaRate";
        public static final String COLUMN_NAME_TO_VALUE = "tValue";
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + HistoryEntry.TABLE_NAME + " (" +
                    HistoryEntry._ID + " INTEGER PRIMARY KEY," +
                    HistoryEntry.COLUMN_NAME_FROM_VALUTA + " TEXT," +
                    HistoryEntry.COLUMN_NAME_FROM_VALUTA_RATE + " REAL," +
                    HistoryEntry.COLUMN_NAME_FROM_VALUE + " REAL,"+
                    HistoryEntry.COLUMN_NAME_TO_VALUTA + " TEXT,"+
                    HistoryEntry.COLUMN_NAME_TO_VALUTA_RATE + " REAL,"+
                    HistoryEntry.COLUMN_NAME_TO_VALUE + " REAL)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + HistoryEntry.TABLE_NAME;


    /**
     * This class is communicants with the db
     *
     *@author CKN
     *@version 1.2
     *@since 1.2
     */
    public static class HistoryReaderDbHelper extends SQLiteOpenHelper {
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "HistoryReader.db";

        public HistoryReaderDbHelper(Context context){
            super(context,DATABASE_NAME,null,DATABASE_VERSION);
        }

        /**
         * Method to create the db
         *
         *@version 1.2
         *@since 1.2
         */
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_ENTRIES);
        }

        /**
         * Method to delete the db and create it again
         *
         *@version 1.2
         *@since 1.2
         */
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(SQL_DELETE_ENTRIES);
            onCreate(db);
        }

        /**
         * Method to delete the db and create it again
         *
         *@version 1.2
         *@since 1.2
         */
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
            onUpgrade(db,oldVersion,newVersion);
        }
    }
}
