package com.example.tp2grupo6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Contacto_Formulario_Extendido extends AppCompatActivity {

    private RadioButton r1,r2,r3,r4,r5;
    private CheckBox ck1, ck2, ck3, ck4;
    private Switch sch;

    //Atributos para recibir los datos del activity Agregar
    private String nombre,apellido,telefono,mail,direccion,fecha,tipoTelefono,tipoMail;
    private String intereses = "", estudio = "", informacion = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto_formulario_extendido);

        //Recepcion de los datos del activity Agregar
        this.nombre=getIntent().getStringExtra("nombre");
        this.apellido=getIntent().getStringExtra("apellido");
        this.telefono=getIntent().getStringExtra("telefono");
        this.mail=getIntent().getStringExtra("mail");
        this.direccion=getIntent().getStringExtra("direccion");
        this.fecha=getIntent().getStringExtra("fecha");
        this.tipoTelefono=getIntent().getStringExtra("tipoTelefono");
        this.tipoMail=getIntent().getStringExtra("tipoMail");

        r1 = (RadioButton) findViewById(R.id.rbPriIncompleto);
        r2 = (RadioButton) findViewById(R.id.rbPriCompleto);
        r3 = (RadioButton) findViewById(R.id.rbSecIncompleto);
        r4 = (RadioButton) findViewById(R.id.rbSecCompleto);
        r5 = (RadioButton) findViewById(R.id.rbOtros);
        ck1 = (CheckBox) findViewById(R.id.chkArte);
        ck2 = (CheckBox) findViewById(R.id.chkDeporte);
        ck3 = (CheckBox) findViewById(R.id.chkMusica);
        ck4 = (CheckBox) findViewById(R.id.chkTecnologia);
        sch = (Switch) findViewById(R.id.switch1);

    }

    public void Guardar(View view){

        if(ck1.isChecked()) intereses += ck1.getText().toString();

        if (ck2.isChecked()) intereses += " " + ck2.getText().toString();

        if (ck3.isChecked()) intereses += " " + ck3.getText().toString();

        if (ck4.isChecked()) intereses += " " + ck4.getText().toString();

        if (r1.isChecked()) estudio = r1.getText().toString();
        if (r2.isChecked()) estudio = r2.getText().toString();
        if (r3.isChecked()) estudio = r3.getText().toString();
        if (r4.isChecked()) estudio = r4.getText().toString();
        if (r5.isChecked()) estudio = r5.getText().toString();

        informacion = (sch.isChecked())? "Si":"No";
        try{
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("agenda.txt", Activity.MODE_APPEND));
            String datos=nombre+","+apellido+","+mail+","+telefono+","+direccion+
                    ","+fecha+","+tipoTelefono+","+tipoMail+ "," + estudio + "," + intereses + "," + informacion +"\n";
            archivo.write(datos);
            archivo.flush();
            archivo.close();
            Toast.makeText(this, "Contacto Guardado", Toast.LENGTH_SHORT).show();
        }
        catch (IOException e){
            Toast.makeText(this, "Error al guardar el contacto", Toast.LENGTH_SHORT).show();
        }

    }


}