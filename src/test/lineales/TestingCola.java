/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;

import lineales.dinamicas2020.Cola;
import lineales.dinamicas2020.Lista;
import lineales.dinamicas.Pila;

/**
 *
 * @author Carla Nuñez
 */
public class TestingCola {

    static String sOk = "OK!", sErr = "ERROR";

    public static void main(String[] arg) {
        testCola();
    }

    public static void testCola() {
        Lista ls = new Lista();
        System.out.println("hola");
        Cola mostrar = new Cola();
        ls.insertar('X', 1);
        ls.insertar('Y', 2);
        ls.insertar('Y', 3);
        ls.insertar('X', 4);
        ls.insertar('Y', 5);
        ls.insertar('X', 6);
        ls.insertar('$', 7);
        

        System.out.println(revisarLista(2, ls));

//    public static Cola generarOtraCola(Cola c1) {
//        Cola colaAux, cR;
//        Pila pilaAux = new Pila();
//        colaAux = c1.clone();
//        cR = new Cola();
//        boolean seguir = true;
//        Object elemAux = colaAux.obtenerFrente();
//        while (colaAux.obtenerFrente() != null) {
//            //En este while va poniendo los elementos a,b,c hasta que encuentra un $
//            while (seguir) {//Utilizo una bandera para saber si quedan elementos en la cola
//                if (colaAux.obtenerFrente() != null) {
//                    if (!colaAux.obtenerFrente().equals('$')) {
//                        cR.poner(colaAux.obtenerFrente());
//                        pilaAux.apilar(colaAux.obtenerFrente());
//                        colaAux.sacar();
//                    } else {
//                        seguir = false;
//                    }
//                } else {
//                    seguir = false;
//                }
//            }
//            seguir = true;
//            //En este while va poniendo los elementos c,b,a hasta que la pile quede vacia
//            while (pilaAux.obtenerTope() != null) {
//                cR.poner(pilaAux.obtenerTope());
//                pilaAux.desapilar();
//            }
//            //Aca pone el $ 
//            if (colaAux.obtenerFrente() != null) {
//                cR.poner(colaAux.obtenerFrente());
//                colaAux.sacar();
//            }
//        }
//        return cR;
//    }
//    
    }

    public static Cola listaToCola(int t, Lista ls) {
        int pos = 1;
        Pila aux = new Pila();
        Cola aux2 = new Cola();

        if (!ls.esVacia()) {
            Lista clonAux = ls.clone();
            int longitud = clonAux.longitud();
            while (pos <= clonAux.longitud()) {
                while (pos <= t && pos <= clonAux.longitud()) {

                    aux2.poner(clonAux.recuperar(pos));
                    aux.apilar(clonAux.recuperar(pos));

                    pos++;
                }
                int x = 1;
                while (x < pos) {
                    clonAux.eliminar(1);
                    x++;
                }

                Pila clonPila = aux.clone();
                while (!aux.esVacia()) {
                    aux2.poner(aux.obtenerTope());
                    aux.desapilar();
                }
                while (!clonPila.esVacia()) {
                    aux2.poner(clonPila.obtenerTope());
                    clonPila.desapilar();
                }

                aux2.poner('&');
                aux2.poner('&');

                pos = 1;
            }

        }
        return aux2;
    }

    public static boolean revisarLista(int x, Lista ls) {
        boolean respuesta = false;
        Pila pilaAux = new Pila();
        int contador = 1;
        if (!ls.esVacia()) {
            Lista lsClon = ls.clone();
            while (contador < lsClon.longitud()) {
                while (contador <= x && contador <= lsClon.longitud()) {
                    pilaAux.apilar(lsClon.recuperar(1));
                    lsClon.eliminar(1);
                    if (contador == x) {
                        if (respuesta = revisarAux(pilaAux, lsClon)) {
                            contador = 0;
                        } else {
                            respuesta = false;
                        }
                    }

                    contador++;

                }

            }
        }
        return respuesta;
    }

//    public static void eliminador(int contador, Lista lsClon) {
//        int t = 1;
//        while (t < contador) {
//            lsClon.eliminar(1);
//
//        }
//    }
    public static boolean revisarAux(Pila pilaAux, Lista lsClon) {
        boolean respuesta = false;
        Pila pilaAux2 = pilaAux.clone();

        while (!pilaAux.esVacia()) {
            if (lsClon.recuperar(1) == pilaAux.obtenerTope()) {
                pilaAux.desapilar();
                lsClon.eliminar(1);
            } else {
                return respuesta;
            }

        }

        while (!pilaAux2.esVacia()) {
            if (lsClon.recuperar(1) == pilaAux2.obtenerTope()) {
                pilaAux2.desapilar();
                lsClon.eliminar(1);

            } else {
                return respuesta;
            }

        }

        if (pilaAux.esVacia() && pilaAux2.esVacia()) {
            if (lsClon.esVacia()) {
                respuesta = true;
            } else if ((char) lsClon.recuperar(1) == '$') {
                respuesta = true;
                lsClon.eliminar(1);
            }

        }
        return respuesta;
    }
}
