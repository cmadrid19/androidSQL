package com.example.sqlite_android.dao;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.sqlite_android.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class BDCoches extends SQLiteOpenHelper {

    private static final String TAG = "SQLite Coches";

    private final String sqlCreacionTablaCoche = "CREATE TABLE COCHE (" +
            "id INTEGER PRIMARY KEY," +
            "matricula TEXT," +
            " marca TEXT," +
            " modelo TEXT," +
            " caballos INTEGER," +
            " color TEXT)";

    public BDCoches(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);  //el método padre, llamará a Oncreate o OnUpgrade, segn corresponda
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlCreacionTablaCoche);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //En caso de que al constructor le pasemos un número de versión distinto a
        // la base de datos existente, este métdo es invocado. Esto sería necesario
        //cuando modificamos la estrucutura de la base de datos

        //Aquí, deberíamos
        // 1 - Extraer los datos de la vieja versión y copiarlos a la nueva instancia
        // 2 - Crear la nueva versión
        // 3 - Cargar los datos en las tablas de la nueva versión
    }



    private void cerrarBaseDatos (SQLiteDatabase database)
    {
        database.close();
    }



    public void insertCoche(Coche coche){
        SQLiteDatabase database = this.getWritableDatabase();
        //FALTA ESCAPAR COMILLAS
        String query = "INSERT INTO COCHE(matricula, marca, modelo, caballos, color) VALUES ("+"\""+coche.matricula+"\""+" , "+"\""+coche.marca+"\""+"," +
                " "+"\""+coche.modelo+"\""+", "+"\""+coche.caballos+"\""+", "+"\""+coche.color+"\")";

        if (database != null){
            try{
                database.execSQL(query);
            }catch (Exception e){
                Log.d(TAG, "error: "+e.getMessage());

            }finally {
                cerrarBaseDatos(database);
            }
        }
    }

    public List<Coche> buscarCoches(){


        List<Coche> lista_coches = null;

        Coche coche = null;

        String matricula;
        String marca;
        String modelo;
        int caballos;
        String color;


        String consulta = "SELECT * FROM COCHE";

        SQLiteDatabase basedatos = this.getReadableDatabase();

        Cursor cursor = basedatos.rawQuery(consulta, null);


        if( cursor != null && cursor.getCount() >0)
        {
            cursor.moveToFirst();

            lista_coches = new ArrayList<>(cursor.getCount());

            do
            {
                matricula = cursor.getString(0); //la posicion primera, el id
                marca = cursor.getString(1);
                modelo = cursor.getString(2);
                caballos = cursor.getInt(3);
                color = cursor.getString(4);

                coche = new Coche(matricula, marca, modelo, caballos, color);
                lista_coches.add(coche);

            }while (cursor.moveToNext());

            cursor.close();
        }

        this.cerrarBaseDatos(basedatos);
        return lista_coches;
    }

}
