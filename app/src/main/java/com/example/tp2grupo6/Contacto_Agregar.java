package com.example.tp2grupo6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Contacto_Agregar extends AppCompatActivity {

    private Spinner spinnerTel, spinnerMail;
    private EditText etNombre, etApellido, etTelefono, etMail, etDireccion, etFecha;

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

        etNombre = (EditText) findViewById(R.id.txtNombre);
        etApellido = (EditText) findViewById(R.id.txtApellido);
        etTelefono = (EditText) findViewById(R.id.txtTelefono);
        etMail = (EditText) findViewById(R.id.txtMail);
        etDireccion = (EditText) findViewById(R.id.txtDireccion);
        etFecha = (EditText) findViewById(R.id.dtFechaNac);
    }

    //Ir a  Contacto Extendido
    public void ContactoExtendido(View view) {
        Intent extendido = new Intent(this, Contacto_Formulario_Extendido.class);
        String nombre=etNombre.getText().toString();
        String apellido=etApellido.getText().toString();
        String telefono=etTelefono.getText().toString();
        String mail=etMail.getText().toString();
        String direccion=etDireccion.getText().toString();
        String fecha=etFecha.getText().toString();
        String tipoTelefono=spinnerTel.getSelectedItem().toString();
        String tipoMail=spinnerMail.getSelectedItem().toString();

        extendido.putExtra("nombre",nombre);
        extendido.putExtra("apellido",apellido);
        extendido.putExtra("telefono",telefono);
        extendido.putExtra("mail",mail);
        extendido.putExtra("direccion",direccion);
        extendido.putExtra("fecha",fecha);
        extendido.putExtra("tipoTelefono",tipoTelefono);
        extendido.putExtra("tipoMail",tipoMail);

        startActivity(extendido);
    }



}