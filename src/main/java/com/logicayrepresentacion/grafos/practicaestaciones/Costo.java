/*
 * Copyright 2019 Carlos Alejandro Escobar Marulanda ealejandro101@gmail.com
 * Permission is hereby granted, free of charge, to any person 
 * obtaining a copy of this software and associated documentation 
 * files (the "Software"), to deal in the Software without 
 * restriction, including without limitation the rights to use, 
 * copy, modify, merge, publish, distribute, sublicense, and/or 
 * sell copies of the Software, and to permit persons to whom the 
 * Software is furnished to do so, subject to the following 
 * conditions:
 * The above copyright notice and this permission notice shall 
 * be included in all copies or substantial portions of the 
 * Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, 
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES 
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 *  WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR 
 * OTHER DEALINGS IN THE SOFTWARE.
 */
package com.logicayrepresentacion.grafos.practicaestaciones;

/**
 *
 * @author Alejandro
 */
public class Costo implements Comparable {

    private final Integer valor;
    private final boolean infinito;
    private static final Costo indeterminado = new Costo();

    public Costo(Integer valor) {
        this.valor = valor;
        this.infinito = false;
    }

    private Costo() {
        valor = 0;
        infinito = true;
    }

    public static  Costo getIndeterminado() {
        return indeterminado;
    }

    @Override
    public int compareTo(Object o) {
        Costo costo2 = (Costo) o;
        if (this.isInfinito()) {
            return 1;
        } else {
            if (costo2.isInfinito()) {
                return -1;
            } else {
                return this.valor.compareTo(costo2.getValor());
            }
        }
    }

    public static Costo menor(Costo costo1, Costo costo2) {
        if (costo1.isInfinito()) {
            return costo2;
        }
        if (costo2.isInfinito()) {
            return costo1;
        }
        if (costo1.compareTo(costo2) > 0) {
            return costo2;
        } else {
            return costo1;
        }
    }

    public static Costo sumar(Costo costo1, Costo costo2) {
        if (costo1.isInfinito() || costo2.isInfinito()) {
            return new Costo();
        } else {
            return new Costo(costo1.getValor() + costo2.getValor());
        }
    }

    public Integer getValor() {
        return valor;
    }

    public boolean isInfinito() {
        return infinito;
    }

    @Override
    public String toString() {
        if (this.isInfinito()) {
            return "i";
        } else {
            return valor + "";
        }
    }

    public static void mostrar(Costo[][] matriz) {
        for (Costo[] matriz1 : matriz) {
            for (Costo m : matriz1) {
                if (m.isInfinito()) {
                    System.out.print("\t" + "i");
                } else {
                    Integer v = m.getValor();
                    System.out.print("\t" + v);
                }

            }
            System.out.println("");
        }
        System.out.println("");
    }

}
