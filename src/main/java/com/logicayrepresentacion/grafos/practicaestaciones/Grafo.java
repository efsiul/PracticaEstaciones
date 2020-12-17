/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicayrepresentacion.grafos.practicaestaciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author 57300
 */
public class Grafo {

    private final int[][] matrizAdy;
    private final int[][] matrizCostos;
    //public Ruta ruta;
    private final int[] ruta;
    public Estacion estacion;
    public DatosEstacion datosEstacion;
    public ArrayList<Subconjunto> conjuntoMayor;
    public ArrayList<Subconjunto> conjuntoSpanningTree;
    public ArrayList<Vertices> vertices;
    public int contadorRelaciones;

    public Grafo(int cantidadEstaciones) {
        matrizAdy = new int[cantidadEstaciones][cantidadEstaciones];
        matrizCostos = new int[cantidadEstaciones][cantidadEstaciones];
        ruta = new int[matrizAdy.length];
    }

    public void addAdyancencia(int vi, int vj, int distancia) {
        matrizAdy[vi][vj] = 1;
        matrizAdy[vj][vi] = 1;
        matrizCostos[vi][vj] = distancia;
        matrizCostos[vj][vi] = distancia;
    }

    public Costo[] dijkstra(int vi) {
        contadorRelaciones = 0;
        Costo[][] costos = new Costo[matrizCostos.length][matrizCostos.length];
        for (int i = 0; i < matrizCostos.length; i++) {
            for (int j = 0; j < matrizCostos.length; j++) {
                if (matrizAdy[i][j] == 0) {
                    costos[i][j] = Costo.getIndeterminado();
                } else {
                    costos[i][j] = new Costo(matrizCostos[i][j]);
                }

                if (matrizCostos[i][j] != 0 && i < j) {
                    contadorRelaciones++;
                }
            }
            ruta[i] = i;
        }

        int[] visitados = new int[matrizCostos.length];
        Costo[] costoMinimo = new Costo[matrizCostos.length];
        for (int j = 0; j < matrizCostos.length; j++) {
            costoMinimo[j] = costos[vi][j];

        }

        visitados[vi] = 1;
        int indice = 0;
        while (indice < matrizCostos.length - 1) {
            int w = escogerMenor(costoMinimo, visitados);
            visitados[w] = 1;

            indice++;
            for (int j = 0; j < visitados.length; j++) {
                if (visitados[j] == 0) {
                    Costo costoJ = costoMinimo[j];
                    Costo distanciaWJ = costos[w][j];
                    Costo costo2 = Costo.sumar(costoMinimo[w], distanciaWJ);
                    costoMinimo[j] = Costo.menor(costoJ, costo2);
                    ruta[j] = w;
                }
            }
            for (int k = 0; k < ruta.length; k++) {
                if (ruta[k] == k && costoMinimo[k].isInfinito()) {
                    ruta[k] = vi;
                }
            }

        }

        System.out.println("Despues de dikstra");
        imprimirCostos();
        return costoMinimo;
    }

    private int escogerMenor(Costo[] costoMinimo, int[] visitados) {
        int w = 0;
        Costo minimow = costoMinimo[w];
        for (int j = 0; j < visitados.length; j++) {
            if (visitados[j] == 0) {
                Costo posiblemenor = Costo.menor(minimow, costoMinimo[j]);
                if (posiblemenor != minimow) {
                    minimow = posiblemenor;
                    w = j;
                }
            }
        }
        return w;
    }

    public int[][] getMatrizAdy() {
        return matrizAdy;
    }

    public int[][] getMatrizCostos() {
        return matrizCostos;
    }


    public void imprimirCostos() {
        String mat = "";
        for (int l = 0; l < matrizCostos.length; l++) {
            for (int m = 0; m < matrizCostos.length; m++) {
                mat += "[" + matrizCostos[l][m] + "]";
            }
            mat += "\n";
        }
        System.out.println(mat);

    }

    public void imprimirRuta() {
        String rut = "";
        for (int l = 0; l < matrizCostos.length; l++) {
            rut += "[" + (ruta[l]) + "]";
        }
        System.out.println("IMPRIMIENDO RUTAAAAA " + rut);
    }

    public ArrayList<Subconjunto> kruskal() {
        int numeroVertices = matrizAdy.length;

        conjuntoMayor = new ArrayList<>();
        vertices = new ArrayList();
        for (int i = 0; i < matrizAdy.length; i++) {
            Vertices v = new Vertices();
            v.AddVertices(i);
            vertices.add(v);

        }

        for (int j = 0; j < matrizCostos.length; j++) {
            for (int k = 0; k < vertices.size(); k++) {

                if (matrizCostos[j][k] != 0 && j < k) {

                    ArrayList<Integer> conjunVertices = new ArrayList<>();
                    conjunVertices.add(j);
                    conjunVertices.add(k);
                    Subconjunto subconjunto = new Subconjunto(conjunVertices, matrizCostos[j][k]);
                    conjuntoMayor.add(subconjunto);

                }

            }

        }
        Collections.sort(conjuntoMayor);
        
        conjuntoSpanningTree = new ArrayList();
        ImprimirConjuntoMayor();
        
        
        while(!conjuntoMayor.isEmpty()){
            int u = conjuntoMayor.get(0).getSubconjunto().get(0);
            int w = conjuntoMayor.get(0).getSubconjunto().get(1);
            conjuntoMayor.remove(0);
            
            for (int i = 0; i < vertices.size(); i++) {
                if(vertices.get(i).getSubVertices().contains(u) && !vertices.get(i).getSubVertices().contains(w)){
                    Subconjunto sbcjnto = new Subconjunto();
                    sbcjnto.addVertice(u);
                    sbcjnto.addVertice(w);
                    conjuntoSpanningTree.add(sbcjnto);
                    for (int j = 0; j < vertices.size(); j++) {
                        if(vertices.get(i).getSubVertices().contains(w) && j != 0){                            
                            vertices.get(j).RemoveVertice(w);
                            vertices.get(0).AddVertices(w);
                        }
                        
                       
                    }
                    if(i != 0){
                            vertices.get(i).RemoveVertice(u);
                            vertices.get(0).AddVertices(u);
                            
                            
                        }                                                                                
                }
                
            }
        
        }
        System.out.println("--------------------CONJUNTO SPANNING TREE---------------------");
        for (int i = 0; i < conjuntoSpanningTree.size(); i++) {
            System.out.println("("+conjuntoSpanningTree.get(i).getSubconjunto().get(0)+","+conjuntoSpanningTree.get(i).getSubconjunto().get(1));            
        }
        return conjuntoSpanningTree;
    }

    public void imprimirSpanningTree() {
        //System.out.println("TAMAÑO CONJUNTO MAYORRRRRRR " + vertices[0].get(0));
        for (int i = 0; i < conjuntoSpanningTree.size(); i++) {
            System.out.println("SPANNING TREE ES " + conjuntoSpanningTree.get(i));

        }
    }
    
    public void ImprimirConjuntoMayor(){
        for (int i = 0; i < conjuntoMayor.size(); i++) {
            System.out.println("CONJUNTO MAYOR ES " + conjuntoMayor.get(i));
            
        }
    }
        
    public void imprimirConjuntoVertices(){
        for (int i = 0; i < vertices.size(); i++) {
            System.out.println("VERTICES" + vertices.get(i));
        }
    }    
 
    

}
