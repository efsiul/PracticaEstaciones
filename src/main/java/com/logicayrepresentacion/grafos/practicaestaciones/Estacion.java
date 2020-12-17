/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicayrepresentacion.grafos.practicaestaciones;

import java.awt.geom.Ellipse2D;

/**
 *
 * @author 57300
 */
public class Estacion implements Comparable<Estacion> {

    private final String nombre;
    private final int id;
    private Ellipse2D forma;

    public Estacion(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int compareTo(Estacion o) {
        return nombre.compareToIgnoreCase(o.getNombre().trim());
    }

    public void setForma(Ellipse2D forma) {
        this.forma = forma;
    }

    public Ellipse2D getForma() {
        return forma;
    }
    
    

}
