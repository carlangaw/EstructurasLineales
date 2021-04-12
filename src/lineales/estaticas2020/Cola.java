/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.estaticas2020;

import lineales.estaticas.*;

/**
 *
 * @author Carla Nuñez
 */
public class Cola {

    private Object[] arreglo;
    private int fin;
    private int frente;
    private static final int TAM = 10;

    public Cola() {
        this.fin = 0;
        this.frente = 0;
        this.arreglo = new Object[TAM];

    }

    public boolean poner(Object elemento) {
        boolean respuesta;
        if (((this.fin + 1) % TAM) == this.frente) {
            respuesta = false;

        } else {
            this.arreglo[fin] = elemento;
            this.fin = (this.fin + 1) % TAM;
            respuesta = true;

        }
        return respuesta;

    }

    public boolean sacar() {
        boolean respuesta = false;
        if (esVacia() != true) {
            this.arreglo[frente] = null;
            this.frente = (this.frente + 1) % TAM;
            respuesta = true;

        }
        return respuesta;
    }

    public boolean esVacia() {
        boolean respuesta = false;
        if (this.frente == this.fin) {
            respuesta = true;
        }
        return respuesta;
    }

    public Object obtenerFrente() {
        Object elemento;
        if (esVacia()) {
            elemento = null;
        } else {
            elemento = this.arreglo[frente];
        }
        return elemento;
    }

    public void vaciar() {
        this.fin = 0;
        this.frente = 0;
    }

    @Override
    public Cola clone() {
        Cola colaClonada = new Cola();
        int i = this.frente;
        while (i != this.fin) {
            colaClonada.arreglo[i] = this.arreglo[i];
            i = (i + 1) % this.TAM;
        }
        colaClonada.frente = this.frente;
        colaClonada.fin = this.fin;
        return colaClonada;
    }

    @Override
    public String toString() {
        String res;
        int aux = this.frente;
        if (fin == frente) {
            res = "cola vacia";
        } else {
            res = "[";
            while (aux != fin) {
                res += this.arreglo[aux];
                aux = (aux + 1) % this.TAM;
                if (aux != fin) {
                    res += ", ";
                }
            }
            res += "]";
        }

        return res;
    }
}
