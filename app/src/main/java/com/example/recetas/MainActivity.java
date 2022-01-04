package com.example.recetas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.recetas.DB.DbHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbHelper dbHelper = new DbHelper(MainActivity.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        if(db!=null){
            Toast.makeText(MainActivity.this, "BASE DE DATOS INICIADA", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this, "ERROR AL CREAR LA BASE DE DATOS", Toast.LENGTH_SHORT).show();
        }
    }



    public void Select_InsertarPlato(View view){
        Intent intento= new Intent(this, InsertarPlatoMain.class);
        startActivity(intento);
    }


    public void Select_GenerarMenu(View view){
       // Intent intento= new Intent(this, InsertarPlatoMain.class);
       // startActivity(intento);
    }
}