package com.paulavelazquez.metegol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.paulavelazquez.metegol.entities.Jugador;

public class Informar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informar);


        Spinner spn1A = (Spinner) findViewById(R.id.spn_1A);
        Spinner spn2A = (Spinner) findViewById(R.id.spn2A);
        Spinner spn1B = (Spinner) findViewById(R.id.spn1B);
        Spinner spn2B = (Spinner) findViewById(R.id.spn2B);

        ArrayAdapter<Jugador> adapter =
                new ArrayAdapter<Jugador>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, Ranking.jugadores);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



        spn1A.setAdapter(adapter);
        spn2A.setAdapter(adapter);
        spn1B.setAdapter(adapter);
        spn2B.setAdapter(adapter);

    }
}
