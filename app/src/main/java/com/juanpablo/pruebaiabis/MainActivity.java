package com.juanpablo.pruebaiabis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    AppCompatTextView salida;
    AppCompatEditText input;
    AppCompatButton btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        salida = (AppCompatTextView) findViewById(R.id.Tv1);
        input = (AppCompatEditText) findViewById(R.id.input);
        btnSend = (AppCompatButton) findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String text = input.getText().toString();
                final String[] result = separaCaracteres(text);
                salida.setText(mostrar(result));
            }
        });
    }

    public String mostrar(String[] cadena) {
        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < cadena.length; i++) {
            result.append("\n---\npalabra: ");
            result.append(i);
            result.append(">>>");
            result.append(cadena[i]);
        }
        return result.toString();
    }

    public String[] separaCaracteres(String cadena) {
        final String separators = "[,. ¿?$]+";
        return cadena.split(separators);
    }
}