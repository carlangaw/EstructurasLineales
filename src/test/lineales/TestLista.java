/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;

import lineales.dinamicas2020.Lista;
import lineales.dinamicas2020.Cola;
import lineales.dinamicas.Pila;
import static test.lineales.TestingCola.testCola;

/**
 *
 * @author Carla Nuñez
 */
public class TestLista {

    public static void main(String[] arg) {
        testLista();

    }

    public static void testLista() {
        Lista mostrar = new Lista();
//
//        Cola colita = new Cola();
//
//        colita.poner(0);
//        colita.poner(1);
//        colita.poner(2);
//        colita.poner(3);
//        colita.poner(4);
//        colita.poner(5);
//
//        System.out.println(generarSecuencia(colita, 5).toString());

        Lista ls = new Lista();
        ls.insertar(1, 1);
        ls.insertar(2, 2);
        ls.insertar(3, 3);
        ls.insertar(4, 4);
        ls.insertar(5, 5);
        ls.insertar(6, 6);
        ls.insertar(7, 7);
        ls.agregarElem(10, 2);
        System.out.println(ls.toString());
    }

    public static Lista colaToLista(int t, Cola colita) {
        int contador = 1;
        Lista ls = new Lista();
        Pila pilaAux = new Pila();
        Cola colaAux = new Cola();
        if (!colita.esVacia()) {
            Cola colitaClon = colita.clone();
            while (!colitaClon.esVacia()) {
                ls.insertar(colitaClon.obtenerFrente(), ls.longitud() + 1);
                colaAux.poner(colitaClon.obtenerFrente());
                pilaAux.apilar(colitaClon.obtenerFrente());
                colitaClon.sacar();
                if (contador == t) {
                    dos(colaAux, ls, pilaAux, t, contador);
                    contador = 0;
                }
                contador++;
            }
            dos(colaAux, ls, pilaAux, t, contador);
        }

        return ls;
    }

    public static void dos(Cola colaAux, Lista ls, Pila pilaAux, int t, int contador) {
        while (!colaAux.esVacia()) {
            ls.insertar(colaAux.obtenerFrente(), ls.longitud() + 1);
            colaAux.sacar();
        }
        while (!pilaAux.esVacia()) {
            ls.insertar(pilaAux.obtenerTope(), ls.longitud() + 1);
            pilaAux.desapilar();
        }

        if (contador == t) {

            ls.insertar('#', ls.longitud() + 1);
            ls.insertar('#', ls.longitud() + 1);
            contador = 1;
        }
    }

    public static Lista generarSecuencia(Cola q, int x) {
        Lista ls = new Lista();
        Pila pilaAux = new Pila();
        Cola colaAux = new Cola();
        Cola colaClon = q.clone();
        int pos = 1;
        if (!q.esVacia()) {
            while (!colaClon.esVacia()) {
                while (pos <= x && !colaClon.esVacia()) {
                    pilaAux.apilar(colaClon.obtenerFrente());
                    colaAux.poner(colaClon.obtenerFrente());
                    colaClon.sacar();
                    if (pos == x) {
                        aux(pilaAux, colaAux, pos, x, ls);
                        pos = 0;
                    }
                    pos++;
                }
                aux(pilaAux, colaAux, pos, x, ls);

            }

        }
        return ls;
    }

    public static void aux(Pila pilaAux, Cola colaAux, int pos, int x, Lista ls) {
        while (!pilaAux.esVacia()) {
            ls.insertar(pilaAux.obtenerTope(), ls.longitud() + 1);
            pilaAux.desapilar();
        }
        while (!colaAux.esVacia()) {
            ls.insertar(colaAux.obtenerFrente(), ls.longitud() + 1);
            colaAux.sacar();
        }
        if (pos == x) {

            ls.insertar('$', ls.longitud() + 1);
            pos = 1;

        }
    }

}
///*
// public static Lista colaToLista(int t, Cola colita) {
//        int contador = 1;
//        Lista ls = new Lista();
//        Pila pilaAux = new Pila();
//        Cola colaAux = new Cola();
//
//        if (!colita.esVacia()) {
//            Cola colitaClon = colita.clone();
//            while (!colitaClon.esVacia()) {
//
//                while (contador <= t && !colitaClon.esVacia()) {
//
//                    ls.insertar(colitaClon.obtenerFrente(), ls.longitud() + 1);
//                    colaAux.poner(colitaClon.obtenerFrente());
//                    pilaAux.apilar(colitaClon.obtenerFrente());
//                    colitaClon.sacar();
//
//                }
//
//                while (!colaAux.esVacia()) {
//                    ls.insertar(colaAux.obtenerFrente(), ls.longitud() + 1);
//                    colaAux.sacar();
//                }
//                while (!pilaAux.esVacia()) {
//                    ls.insertar(pilaAux.obtenerTope(), ls.longitud() + 1);
//                    pilaAux.desapilar();
//                }
//                System.out.println(contador);
//                System.out.println(t);
//                if (!colitaClon.esVacia()) {
//
//                    ls.insertar('#', ls.longitud() + 1);
//                    ls.insertar('#', ls.longitud() + 1);
//                    contador = 1;
//                }
//                contador++;
//            }
//
//        }
//        return ls;
//    }
//}
//
// 
