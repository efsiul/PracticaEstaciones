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
public class Vertices {
    ArrayList<Integer> subVertices = new ArrayList();

    public ArrayList<Integer> getSubVertices() {
        return subVertices;
    }

    public void setSubVertices(ArrayList<Integer> subVertices) {
        this.subVertices = subVertices;
    }

    public Vertices(ArrayList<Integer> x) {
        this.subVertices=x;
    }
    public Vertices(){
        
    }
    
    public void AddVertices(int x){
        subVertices.add(x);
    }
    
    public void RemoveVertice(int x){
        subVertices.remove(subVertices.indexOf(x));
    }
    
    
}
