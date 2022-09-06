package com.example.tp2grupo6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Contacto_Lista extends AppCompatActivity {
    private ListView lvAgenda;

    //HARDCODEO DEL ARRAY PARA EL ARRAYADAPTER DEL LISTVIEW PARA PROBAR SI LEVANTA LOS DATOS
    private String listaNombres []={"Tito","Pancho","Colo","Beto"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto_lista);

        //ESTA LINEA SE TRAE EN UN STRING LO GUARDADO EN EL ARCHIVO, PERO SOLO ESO
        String agenda=abrir("agenda.txt");

        this.lvAgenda=(ListView)findViewById(R.id.lvAgenda);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.listview_item_agenda,listaNombres);
        lvAgenda.setAdapter(adapter);
    }

    //EL METODO ABRE UN ARCHIVO Y DEVUELVE UN STRING CON SU CONTENIDO. SI ESTA VACIO DEVUELVE UN STRING VACIO
    public String abrir(String nombreArchivo){
        String agenda="";
        try{
            InputStreamReader archivo = new InputStreamReader(openFileInput(nombreArchivo));
            BufferedReader lector= new BufferedReader(archivo);
            String linea= lector.readLine();
            while(linea!=null){
                agenda= agenda+linea+"\n";
                linea=lector.readLine();
            }
            lector.close();
            archivo.close();
        }
        catch(IOException e){

        }
        return agenda;
    }




}