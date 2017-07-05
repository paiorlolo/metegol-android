package com.paulavelazquez.metegol;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.paulavelazquez.metegol.entities.Jugador;

public class Home extends AppCompatActivity {
    private static final int ABM_RESULT = 1988;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void goToRanking(View v){
        Intent intent = new Intent(this, Ranking.class);
        startActivity(intent);
    }
    public void goToABM(View v){



        Intent intent = new Intent(this, ABM.class);
        startActivityForResult(intent, ABM_RESULT);
    }
    public void goToInformar(View v){
        Intent intent = new Intent(this, Informar.class);
        startActivity(intent);
    }

    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == ABM_RESULT){

        switch (resultCode) {
            case RESULT_OK:

                String nombreJugador = data.getStringExtra("nombreJugador");
                Toast toast = Toast.makeText(getApplicationContext(),"Se creo el jugador "+nombreJugador,Toast.LENGTH_SHORT );
                toast.show();
                break;

            case RESULT_CANCELED:
                // Cancelación o cualquier situación de error
                break;
            }
        }
    }

}
