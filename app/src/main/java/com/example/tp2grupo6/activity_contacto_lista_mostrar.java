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

        //TextView myText = (TextView) findViewById(R.id.TextViewSeMostrara);
        //myText.setText("\n\n\n Se mostraran los datos de: \n\n"+valor);

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
                if (valor.equals(partes[0] + " " + partes[1] + " - " + partes[2])) {
                    TextView txtNombre = (TextView) findViewById(R.id.txtLblNombre);
                    TextView txtTelefono = (TextView) findViewById(R.id.txtLblTelefono);
                    TextView txtEmail = (TextView) findViewById(R.id.txtLblEmail);
                    TextView txtDireccion = (TextView) findViewById(R.id.txtLblDireccion);
                    TextView txtFecha = (TextView) findViewById(R.id.txtLblFecha);
                    TextView txtEstudios = (TextView) findViewById(R.id.txtLblEstudios);
                    TextView txtInteres = (TextView) findViewById(R.id.txtLblInteres);

                    txtNombre.setText(partes[0] + " " + partes[1]);
                    txtTelefono.setText(partes[3] + " - " + partes[6]);
                    txtEmail.setText(partes[2] + " - " + partes[7]);
                    txtDireccion.setText(partes[4]);
                    txtFecha.setText(partes[5]);
                    txtEstudios.setText(partes[8]);
                    txtInteres.setText(partes[9]);

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