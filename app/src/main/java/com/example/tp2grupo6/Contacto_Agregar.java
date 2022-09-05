package com.example.tp2grupo6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Contacto_Agregar extends AppCompatActivity {

    private Spinner spinnerTel;
    private Spinner spinnerMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto_agregar);
        spinnerTel = (Spinner)findViewById(R.id.spinnerTel);

        //Genero el array de spinner y lo adapto
        String [] Opciones = {"Casa", "Trabajo", "Movil"};
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,Opciones);

        //Le acargo el objeto al spinner
        spinnerTel.setAdapter(adapter);

        spinnerMail = (Spinner)findViewById(R.id.spinnerMail);
        spinnerMail.setAdapter(adapter);
    }


    //Ir a  Contacto Extendido
    public void ContactoExtendido(View view) {
        Intent Extendido = new Intent(this, Contacto_Formulario_Extendido.class);
        startActivity(Extendido);

    }



}