package com.paulavelazquez.metegol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.paulavelazquez.metegol.entities.Jugador;

public class ABM extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abm);

    }
    public void agregarJugador(View v){
        EditText nombre = (EditText) findViewById(R.id.etNombre);
        String nombreIngresado= nombre.getText().toString();
        if(nombreIngresado!=null){
            Jugador j= new Jugador(nombreIngresado,0,0,0);
            Ranking.jugadores.add(j);

            Intent resultIntent = new Intent();
            resultIntent.putExtra("nombreJugador", nombreIngresado);

            setResult(RESULT_OK,resultIntent);
            finish();

        }
    }
}
