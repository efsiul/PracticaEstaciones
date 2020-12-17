/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicayrepresentacion.grafos.practicaestaciones;

import java.util.ArrayList;

/**
 *
 * @author 57300
 */
class Ruta {

    ArrayList<Integer> ruta = new ArrayList<>();
    int distancia = 0;

    public void addEstacion(Integer estacion){ //,int distancia) {
        ruta.add(estacion);
        //this.distancia = distancia;
    }

    public int getDistancia() {
        return distancia;
    }

    public ArrayList<Integer> getRuta() {
        return ruta;
    }

}
