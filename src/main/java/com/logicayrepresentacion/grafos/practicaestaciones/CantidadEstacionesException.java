/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicayrepresentacion.grafos.practicaestaciones;

/**
 *
 * @author 57300
 */
public class CantidadEstacionesException extends Exception {

    CantidadEstacionesException(String sobrepaso_la_cantidad_de_estaciones) {
        super(sobrepaso_la_cantidad_de_estaciones);
    }
    
}
