package com.example.sqlite_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.sqlite_android.dao.BDCoches;
import com.example.sqlite_android.dao.Coche;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BDCoches dbCoches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializamos dbCoches
        dbCoches = new BDCoches(this, "miDB", null, 1);


        dbCoches.insertCoche(new Coche("2727APK", "Seat", "Ibiza", 100, "Rojo"));
        dbCoches.insertCoche(new Coche("1111AAA", "Bmw", "320", 120, "Blanco"));
        dbCoches.insertCoche(new Coche("2222EEE", "Mercedes", "CLA", 130, "Verde"));
        dbCoches.insertCoche(new Coche("4444ABS", "Ferrari", "La ferrari", 300, "Azul"));
        dbCoches.insertCoche(new Coche("6666VOX", "Porsche", "911", 300, "Amarillo"));


        List<Coche> listaCoches= dbCoches.buscarCoches();

        if (listaCoches != null){
            for (Coche c: listaCoches){
                Log.d("Coche", c.toString());
            }
        }



    }







}
