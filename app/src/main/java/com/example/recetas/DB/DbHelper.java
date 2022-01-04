package com.example.recetas.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NOMBRE = "CheckMenu.db";
    protected static final String TABLA_PLATOS = "t_Platos";
    protected static final String TABLA_RESTAURANTE = "t_Restaurante";


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLA_PLATOS +"("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre STRING NOT NULL,"+
                "descripcion STRING NOT NULL,"+
                "proteinas FLOAT NOT NULL,"+
                "calorias FLOAT NOT NULL,"+
                "hidratosCarbono FLOAT NOT NULL,"+
                "grasa FLOAT NOT NULL,"+
                "alergenos STRING NOT NULL,"+
                "casero INTEGER NOT NULL,"+ //0 para no casero, 1 para casero
                "tipo STRING NOT NULL,"+ //desayuno/almuerzo/cena
                "receta STRING,"+
                "enlaces STRING"+
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLA_PLATOS);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLA_RESTAURANTE);
        onCreate(sqLiteDatabase);
    }
}
