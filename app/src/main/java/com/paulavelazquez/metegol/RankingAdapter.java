package com.paulavelazquez.metegol;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;

import com.paulavelazquez.metegol.entities.Jugador;

import java.util.ArrayList;

/**
 * Created by Paula on 15/06/2017.
 */
public class RankingAdapter extends BaseAdapter {
    Activity act;
    ArrayList jugadores;
    Resources resources;
    private static LayoutInflater inflater=null;
    public TextView txtNombre;
    public TextView txtPG;
    public TextView txtPP;
    public TextView txtPJ;


    public RankingAdapter(Activity act, ArrayList jugadores, Resources resources) {
        this.act = act;
        this.jugadores = jugadores;
        this.resources = resources;
        inflater = (LayoutInflater)act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return jugadores.size();
    }

    @Override
    public Object getItem(int position) {

        return jugadores.get(position);

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if(convertView==null) {
            vi = inflater.inflate(R.layout.custom_ranking, null);

        }

       txtNombre = (TextView) vi.findViewById(R.id.txtNombre);
        txtPG  = (TextView) vi.findViewById(R.id.txtPG);
        txtPP = (TextView) vi.findViewById(R.id.txtPP);
        txtPJ  = (TextView) vi.findViewById(R.id.txtPJ);

        Integer pj = ((Jugador)getItem(position)).getpGanados()+((Jugador)getItem(position)).getpPerdidos();
        txtNombre.setText(((Jugador)getItem(position)).getNombre());
        txtPG.setText(((Jugador)getItem(position)).getpGanados().toString());
        txtPP.setText(((Jugador)getItem(position)).getpPerdidos().toString());
        txtPJ.setText(pj.toString());


        return vi;
    }
}
