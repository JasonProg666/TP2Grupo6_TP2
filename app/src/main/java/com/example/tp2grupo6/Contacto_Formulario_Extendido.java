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
    private String nombre,apellido,telefono,mail,direccion,fecha,tipoTelefono,tipoMail,agenda;

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
        this.agenda=abrir("agenda.txt");
    }

    //METODO PARA GUARDAR, AHORA SOLO GUARDA LO INGRESADO EN EL ACTIVITY ANTERIOR
    //GUARDA UN RENGLON CON LOS DATOS INGRESADOS PERO AL GUARDAR OTRO CONTACTO SE SOBREESCRIBE
    //HABRIA QUE CONCATENAR LO GUARDADO PREVIAMENTE CON LO QUE SE VA A GUARDAR AHORA Y SOBREESCRIR EL ARCHIVO
    //DEBE HABER OTRAS MANERAS DE HACERLO
    public void Guardar(View view){
        try{
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("agenda.txt", Activity.MODE_PRIVATE));
            String datos=nombre+","+apellido+","+telefono+","+mail+","+direccion+
                    ","+fecha+","+tipoTelefono+","+tipoMail+"\n";
            archivo.write(datos);
            archivo.flush();
            archivo.close();
        }
        catch (IOException e){

        }
        Toast.makeText(this, "Contacto Guardado", Toast.LENGTH_SHORT).show();
    }

    //EL METODO ABRE UN ARCHIVO Y DEVUELVE UN STRING CON SU CONTENIDO. SI ESTA VACIO DEVUELVE UN STRING VACIO
    //LO ARME ACA PARA VER SI PODIA CONCATENAR LO GUARDADO ANTERIORMENTE CON LO QUE SE VA A GUARDAR AHORA
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