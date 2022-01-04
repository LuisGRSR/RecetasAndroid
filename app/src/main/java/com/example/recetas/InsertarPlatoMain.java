package com.example.recetas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recetas.DB.DbHelper;
import com.example.recetas.DB.DbPlatos;
import com.example.recetas.Enum.Alergenos;
import com.example.recetas.Enum.TipoComida;

import java.util.ArrayList;
import java.util.List;

public class InsertarPlatoMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_plato_main);
    }


    public void CrearPrueba(View view){



        EditText Nombre;
        String Descripcion, Receta, Enlaces;
        float Proteinas, Calorias, HidratosCarbono, Grasa;
        boolean Casero;
        TipoComida Tipo;
        List<Alergenos> Alergenos= new ArrayList<>();

        Nombre=findViewById(R.id.NombrePlato);

        //Queda por hacer
        Descripcion="Descripcion";
        Proteinas= new Float(2.2);
        Calorias=new Float(2.4);
        HidratosCarbono=new Float(2.2);
        Grasa= new Float(2.2);
        Casero= true;
        Tipo= TipoComida.ALMUERZO;
        Receta= "Receta";
        Enlaces= "Enlaces";




        DbPlatos dbPlatos= new DbPlatos(InsertarPlatoMain.this);
        long id= dbPlatos.insertarPlato(Nombre.getText().toString(),Descripcion,Proteinas,Calorias,HidratosCarbono,Grasa,Alergenos,Casero,Tipo,Receta,Enlaces);

    }
}