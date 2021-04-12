/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 *
 * @author Carla Nuñez
 */
 class NodoLista {

    private Object elemento;
    private NodoLista enlace;

    public NodoLista(Object elemento, NodoLista enlace) {
        this.elemento = elemento;
        this.enlace = enlace;

    }

    public NodoLista(Object elemento) {
        this.elemento = elemento;

    }

    public Object getElemento() {
        return this.elemento;

    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;

    }

    public NodoLista getEnlace() {
        return this.enlace;
    }

    public void setEnlace(NodoLista enlace) {
        this.enlace = enlace;

    }
}
