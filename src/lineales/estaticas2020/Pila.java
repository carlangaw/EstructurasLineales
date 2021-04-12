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
public class Pila {

    private Object[] arreglo;
    private int tope;
    private static final int TAM = 10;

    public Pila() {
        this.arreglo = new Object[TAM];
        this.tope = -1;

    }


    public boolean apilar(Object nuevoElem) {
        boolean exito = false;
        /* verifico si la pila NO esta llena para apilar */
        if (!(this.tope + 1 >= TAM)) {
            this.tope++;
            arreglo[tope] = nuevoElem;
            exito = true;
        }
        return exito;
    }

    public boolean desapilar() {
        boolean respuesta = false;
        if (this.tope != -1) {
            this.arreglo[tope] = null;
            tope--;
            respuesta = true;

        }
        return respuesta;
    }

    public Object obtenerTope() {
        Object elemento;
        if (this.tope == -1) {
            elemento = null;

        } else {
            elemento = this.arreglo[tope];
        }
        return elemento;
    }

    public void vaciar() {
        // Saca todos los elementos de la pila
        while (this.tope >= 0) {
            this.arreglo[tope] = null;
            tope--;
        }
    }

    public boolean esVacia() {
        // Devuelve verdadero si la pila no tiene elementos y falso en caso contrario.
        boolean respuesta = false;
        if (this.tope == -1) {
            respuesta = true;
        }

        return respuesta;

    }

    @Override
    public Pila clone() {
        Pila pilaClon = new Pila();
        pilaClon.tope = this.tope;
        for (int i = 0; i <= this.tope; i++) {
            pilaClon.arreglo[i] = this.arreglo[i];
        }
        return pilaClon;
    }

    @Override
    public String toString() {
        String cadena = "[";
        for (int i = 0; i <= this.tope; i++) {
            cadena += this.arreglo[i] + " , ";
        }
        cadena += "]";
        return cadena;
    }
}
