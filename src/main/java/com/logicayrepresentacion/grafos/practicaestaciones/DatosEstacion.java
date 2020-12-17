/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicayrepresentacion.grafos.practicaestaciones;

import arbol.binario.listaligada.busqueda.avl.ArbolAVL;
import arbol.binario.listaligada.busqueda.avl.NodoAVL;
import javax.swing.JTextPane;

/**
 *
 * @author 57300
 */
public class DatosEstacion {

    Estacion[] estaciones;
    ArbolAVL<Estacion> arbolAVL = new ArbolAVL();
    private static int SIGUIENTE_ID = 0;
    private final Grafo grafo;

    private JTextPane costoMinimojTextPane1;
    private JTextPane matrizAdyjTextPane1;

    public DatosEstacion(int c, JTextPane costoMinimojTextPane1, JTextPane matrizAdyjTextPane1) {
        SIGUIENTE_ID = 0;
        estaciones = new Estacion[c];
        grafo = new Grafo(c);
    }

    public Estacion add(String ciudad1) throws CantidadEstacionesException {

        NodoAVL<Estacion> nodo = arbolAVL.buscar(new Estacion(ciudad1, -1));
        if (nodo == null) {
            int siguienteID = DatosEstacion.nextSIGUIENTE_ID();
            if (siguienteID >= estaciones.length) {
                throw new CantidadEstacionesException("Sobrepaso la cantidad de estaciones");
            }
            Estacion estacion = new Estacion(ciudad1, siguienteID);
            arbolAVL.insertarDato(estacion);
            estaciones[estacion.getId()] = estacion;
            return estacion;
        } else {
            return (Estacion) nodo.getDato();
        }
    }

    public static int nextSIGUIENTE_ID() {
        int actual = SIGUIENTE_ID;
        SIGUIENTE_ID++;
        return actual;
    }

    public static int getSIGUIENTE_ID() {
        return SIGUIENTE_ID;
    }

    public Estacion[] getEstaciones() {
        return estaciones;
    }

    public Estacion buscar(String ciudad1) {
        NodoAVL<Estacion> nodo = arbolAVL.buscar(new Estacion(ciudad1, -1));
        if (nodo == null) {
            return null;
        } else {
            return (Estacion) nodo.getDato();
        }
    }

    public void addAdyacencia(String ciudad1, String ciudad2, int distancia) throws CantidadEstacionesException {
        Estacion estacion1 = add(ciudad1);
        Estacion estacion2 = add(ciudad2);
        grafo.addAdyancencia(estacion1.getId(), estacion2.getId(), distancia);
    }
    
    /*public String floyd(){
        return grafo.algoritmoFloyd();
    }*/

    public Grafo getGrafo() {
        return grafo;
    }

    public Estacion getEstacion(int x) {
        return estaciones[x];
    }

    public void obtenerCostoMinimo(int vi) {
        StringBuilder cadena = new StringBuilder();
        Costo[] costoMinimo = grafo.dijkstra(vi);
        for (Costo costo : costoMinimo) {
            cadena.append(costo + " - ");
        }

        System.out.println("Costo minimo " + vi + " " + cadena);
        if (costoMinimojTextPane1 != null) {
            costoMinimojTextPane1.setText(cadena.toString());
        }
        grafo.imprimirRuta();
    }

    public String parseMatrizAdy() {
        StringBuilder matrizEnTexto = new StringBuilder();

        int[][] matrizAdy = grafo.getMatrizAdy();

        for (int i = 0; i < matrizAdy.length; i++) {
            matrizEnTexto.append("   " + i);
        }
        matrizEnTexto.append("\n");

        for (int i = 0; i < matrizAdy.length; i++) {
            matrizEnTexto.append(i + "   ");
            for (int j = 0; j < matrizAdy.length; j++) {
                matrizEnTexto.append(matrizAdy[i][j] + "   ");
            }
            matrizEnTexto.append("\n");
        }
        return matrizEnTexto.toString();
    }

    public String parseMatrizCostos() {
        StringBuilder matrizEnTexto = new StringBuilder();

        int[][] matriz = grafo.getMatrizCostos();

        for (int i = 0; i < matriz.length; i++) {
            matrizEnTexto.append("   " + i);
        }
        matrizEnTexto.append("\n");

        for (int i = 0; i < matriz.length; i++) {
            matrizEnTexto.append(i + "   ");
            for (int j = 0; j < matriz.length; j++) {
                matrizEnTexto.append(matriz[i][j] + "   ");
            }
            matrizEnTexto.append("\n");
        }
        return matrizEnTexto.toString();
    }

}
