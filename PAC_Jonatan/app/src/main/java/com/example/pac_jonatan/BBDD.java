package com.example.pac_jonatan;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BBDD extends SQLiteOpenHelper {

    private static final String TABLE_CREATE = "CREATE TABLE Clientes(_id INTEGER PRIMARY KEY AUTOINCREMENT, Nombre TEXT, Apellido TEXT, Correo TEXT)";
    private static final String DB_NAME = "Clientes.sqlite";
    private static final int DB_VERSION = 1;

    public BBDD(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
