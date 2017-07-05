package com.paulavelazquez.metegol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.paulavelazquez.metegol.entities.Jugador;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

public class Ranking extends AppCompatActivity {
    static ArrayList<Jugador> jugadores= new ArrayList<Jugador>();
    ListView list;
    RankingAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        list = (ListView)findViewById(R.id.lstRanking);
        adapter = new RankingAdapter(this, jugadores, getResources());
        list.setAdapter(adapter);

    }
}
