/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicayrepresentacion.grafos.practicaestaciones;

import java.util.ArrayList;


/**
 *
 * @author Luis Felipe Cadavid
 */
public class Subconjunto implements Comparable {
    
    ArrayList<Integer> subconjunto;
    int distanciasVertices = 0;

    public ArrayList<Integer> getSubconjunto() {
        return subconjunto;
    }

    public void setSubconjunto(ArrayList<Integer> subconjunto) {
        this.subconjunto = subconjunto;
    }

    public Subconjunto() {
        subconjunto = new ArrayList<>();
    }
    
    

    public int getDistanciasVertices() {
        return distanciasVertices;
    }

    public void setDistanciasVertices(int distanciasVertices) {
        this.distanciasVertices = distanciasVertices;
    }
    

    public Subconjunto(ArrayList<Integer> subconjunto, int distancias) {
        this.subconjunto = subconjunto;
        this.distanciasVertices=distancias;
    }
    
    public void addVertice(int x){
        subconjunto.add(x);
    }

    public void removeVertice(int x){
        subconjunto.remove(subconjunto.indexOf(x));
    }
    @Override
    public String toString() {       
        return "["+this.subconjunto.get(0)+","+this.subconjunto.get(1)+"]" 
                + "," + this.distanciasVertices;
                  
    }

    @Override
    public int compareTo(Object o) {
        int subconjunto2 = ( (Subconjunto) o).getDistanciasVertices();
        
        return distanciasVertices-subconjunto2;
    }
    
}
