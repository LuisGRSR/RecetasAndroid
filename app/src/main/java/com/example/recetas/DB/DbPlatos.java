package com.example.recetas.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.recetas.Enum.Alergenos;
import com.example.recetas.Enum.TipoComida;

import java.util.List;

public class DbPlatos extends DbHelper{

    Context context;

    public DbPlatos(@Nullable Context context){
        super(context);
        this.context=context;
    }

    public long insertarPlato(String nombre, String descripcion , float proteinas, float calorias, float hidratosCarbono, float grasa, List<Alergenos> alergenos,Boolean casero, TipoComida tipo, String receta, String enlaces){
        int caseroNum;
        if(casero){
            caseroNum=1;
        }else{
            caseroNum=0;
        }

        long id = 0;

        try{

            DbHelper dbHelper= new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values= new ContentValues();
            values.put("nombre",nombre);
            values.put("descripcion",descripcion);
            values.put("proteinas",proteinas);
            values.put("calorías",calorias);
            values.put("hidratosCarbono",hidratosCarbono);
            values.put("grasa",grasa);
            values.put("alergenos",alergenos.toString());
            values.put("casero",caseroNum);
            values.put("tipo",tipo.toString());
            values.put("receta",receta);
            values.put("enlaces",enlaces);

            id = db.insert(TABLA_PLATOS,null,values);


        }catch (Exception ex){
            ex.toString();
        }

        return id;



    }
}
