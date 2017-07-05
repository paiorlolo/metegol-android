package com.paulavelazquez.metegol.entities;

/**
 * Created by Paula on 15/06/2017.
 */

public class Jugador {
    String nombre;
    Integer puntos;
    Integer pGanados;
    Integer pPerdidos;


    public Jugador(String nombre, Integer puntos, Integer pGanados, Integer pPerdidos) {
        this.nombre = nombre;
        this.puntos = puntos;
        this.pGanados = pGanados;
        this.pPerdidos = pPerdidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public Integer getpPerdidos() {
        return pPerdidos;
    }

    public void setpPerdidos(Integer pPerdidos) {
        this.pPerdidos = pPerdidos;
    }



    public Integer getpGanados() {
        return pGanados;
    }

    public void setpGanados(Integer pGanados) {
        this.pGanados = pGanados;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
