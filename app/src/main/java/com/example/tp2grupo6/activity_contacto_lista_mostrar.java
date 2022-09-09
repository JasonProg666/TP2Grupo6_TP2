package com.example.tp2grupo6;

import static java.util.Arrays.stream;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class activity_contacto_lista_mostrar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto_lista_mostrar);

        Intent secondIntent = getIntent( );
        String valor = secondIntent.getStringExtra("SELECCIONADO");

        TextView myText = (TextView) findViewById(R.id.TextViewSeMostrara);
        myText.setText("\n\n\n Se mostraran los datos de: \n\n"+valor);

        mostrar(valor);
    }

    
    public void mostrar(String valor){
        String agenda="";
        try{
            InputStreamReader archivo = new InputStreamReader(openFileInput("agenda.txt"));
            BufferedReader lector= new BufferedReader(archivo);
            String linea= lector.readLine();
            while(linea!=null){

                agenda= linea+"\n\n\n";
                //corto la cadena solo para mostrar el nombre, apellido y mail
                String[] partes = agenda.split(",");

                //ACA FALTA MATCHEAR LA FILA CON EL VALOR QUE TENGO DEL OTRO LADO (Nombre Apellido y TELEFONO)
                if (stream(partes).anyMatch(valor::equals)) {
                    TextView myText = (TextView) findViewById(R.id.TextView);
                    TextView myText2 = (TextView) findViewById(R.id.TextView2);
                    TextView myText3 = (TextView) findViewById(R.id.TextView3);
                    TextView myText4 = (TextView) findViewById(R.id.TextView4);
                    TextView myText5 = (TextView) findViewById(R.id.TextView5);
                    TextView myText6 = (TextView) findViewById(R.id.TextView6);

                    myText.setText(valor);
                    myText2.setText(partes[1]);
                    myText3.setText(partes[2]);
                    myText4.setText(partes[3]);
                    myText5.setText(partes[4]);
                    myText6.setText(partes[5]);

                    lector.close();
                    archivo.close();
                    return;
                }
                linea=lector.readLine();
            }
            lector.close();
            archivo.close();
        }
        catch(IOException e){
        }
        return ;
    }

}