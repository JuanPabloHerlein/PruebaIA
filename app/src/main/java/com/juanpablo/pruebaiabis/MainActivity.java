package com.juanpablo.pruebaiabis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView salida;
    String []CADENA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        salida=(TextView)findViewById(R.id.Tv1);
        CADENA=separaCaracteres("hola juan$ pablo, ¿como estas?.","[,. ¿?]+");
        //salida.setText(""+CADENA);
        salida.setText(mostrar(CADENA));

    }


    public String mostrar(String []cadena){
        String r="";
        for(int i=0;i<cadena.length;i++){
            r += ("\n---\npalabra: " + i +">>>"+ cadena[i]);

        }
        return r;
    }


    public String[] separaCaracteres(String cadena, String separator){
        //System.out.println("Separator: " + separator);
        String[] parts = null;
        if(separator.equals("|")|| separator.equals("\\")||separator.equals(".")||separator.equals("^")||separator.equals("$")
                ||separator.equals("?")||separator.equals("*")||separator.equals("+")||separator.equals("(")||separator.equals(")")
                ||separator.equals("{")||separator.equals("[")||separator.equals(" ")){
            //Es metacaracter!
            parts = cadena.split(" "+separator);
        }else{
            //No es metacaracter.
            parts = cadena.split(separator);
        }
        return parts;
    }
}