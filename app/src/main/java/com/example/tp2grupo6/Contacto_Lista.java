package com.example.tp2grupo6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Contacto_Lista extends AppCompatActivity {

    private ListView lvAgenda;
    private List<String> contactos = new ArrayList<>();
    private Intent myIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myIntent = new Intent(this, activity_contacto_lista_mostrar.class);

        setContentView(R.layout.activity_contacto_lista);

        this.contactos = abrir("agenda.txt");
        this.lvAgenda=(ListView)findViewById(R.id.lvAgenda);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.listview_item_agenda,contactos);
        lvAgenda.setAdapter(adapter);

        lvAgenda.setOnItemClickListener( listClick );

    }

    //NUEVO
    private AdapterView.OnItemClickListener listClick = new AdapterView.OnItemClickListener () {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            String itemvalue = (String) lvAgenda.getItemAtPosition(position);
            myIntent.putExtra("SELECCIONADO", itemvalue);
            startActivity(myIntent);
        }
    };


    //EL METODO ABRE UN ARCHIVO Y DEVUELVE UN STRING CON SU CONTENIDO. SI ESTA VACIO DEVUELVE UN STRING VACIO
    public List<String> abrir(String nombreArchivo){
        List<String> lcontactos = new ArrayList<>();
        String agenda="";
        try{
            InputStreamReader archivo = new InputStreamReader(openFileInput(nombreArchivo));
            BufferedReader lector= new BufferedReader(archivo);
            String linea= lector.readLine();
            while(linea!=null){
                agenda= linea+"\n";

                //corto la cadena solo para mostrar el nombre, apellido y mail
                String[] partes = agenda.split(",");
                lcontactos.add(partes[0] + " " + partes[1] + " - " + partes[3]);

                //para que se muestran todos los datos
                //lcontactos.add(agenda);
                linea=lector.readLine();
            }
            lector.close();
            archivo.close();
        }
        catch(IOException e){
        }
        return lcontactos;
    }



}