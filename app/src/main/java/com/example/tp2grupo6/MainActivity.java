package com.example.tp2grupo6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Ir a Agregar Contacto
    public void ContactoAgregar(View view) {
        Intent Agregar = new Intent(this, Contacto_Agregar.class);
        startActivity(Agregar);

    }


    //Ir a Agregar Contacto
    public void ContactoLista(View view) {
        Intent Lista = new Intent(this, Contacto_Lista.class);
        startActivity(Lista);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu mimenu) {
        getMenuInflater().inflate(R.menu.menuenactivity, mimenu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem OpcionMenu) {
        int id = OpcionMenu.getItemId();
        if (id == R.id.Agregar) {

            ContactoAgregar(null);
            return true;

        } else if (id == R.id.Lista) {
            //LLamar a lista de contactos
            ContactoLista(null);
        }

        return true;
    }
}