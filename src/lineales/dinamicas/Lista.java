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
public class Lista {

    private NodoLista cabecera;

    public Lista() {
        this.cabecera = null;
    }

    public boolean insertar(Object elemento, int pos) {
        boolean respuesta = true;
        if (pos < 1 || pos > this.longitud() + 1) {

            respuesta = false;
        } else if (pos == 1) {
            this.cabecera = new NodoLista(elemento, this.cabecera);

        } else {
            //avanza hasta el elemento en posicion -1                 
            NodoLista aux = this.cabecera;
            int i = 1;
            while (i < pos - 1) {
                aux = aux.getEnlace();
                i++;
            }
            //crea el nodo y lo enlaza
            NodoLista nuevo = new NodoLista(elemento, aux.getEnlace());
            aux.setEnlace(nuevo);
        }

        return respuesta;
    }

    public int longitud() {
        NodoLista nuevoNodo = this.cabecera;
        int contador = 1;
        if (nuevoNodo == null) {
            contador = 0;
        } else {
            while (nuevoNodo.getEnlace() != null) {
                nuevoNodo = (NodoLista) nuevoNodo.getEnlace();
                contador++;
            }
        }
        return contador;
    }

    public boolean eliminar(int pos) {
        boolean respuesta = false;
        if (pos >= 1 && pos <= this.longitud()) {
            if (pos == 1) {
                this.cabecera = this.cabecera.getEnlace();
                respuesta = true;
            } else {
                NodoLista aux = this.cabecera;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;

                }
                aux.setEnlace(aux.getEnlace().getEnlace());
                respuesta = true;
            }
        }
        return respuesta;
    }

    public Object recuperar(int pos) {
        Object elemento = null;
        if (pos >= 1 && pos <= this.longitud()) {
            if (pos == 1) {
                elemento = this.cabecera;
            } else {
                NodoLista aux = this.cabecera;
                int i = 1;
                while (i != pos) {
                    aux = aux.getEnlace();
                    i++;

                }
                elemento = aux.getElemento();
            }
        }
        return elemento;
    }

    public int localizar(Object elemento) {
        int posicion = -1;
        int i = 1;
        NodoLista aux = this.cabecera;

        if (this.cabecera != null) {
            if (this.cabecera.getElemento().equals(elemento)) {
                posicion = 1;
            } else {

                while (i < this.longitud() && !elemento.equals(aux.getElemento())) {
                    aux = aux.getEnlace();
                    i++;
                    if (elemento.equals(aux.getElemento())) {
                        posicion = i;
                    }

                }
            }
        }
        return posicion;
    }

    public void vaciar() {
        this.cabecera = null;

    }

    public boolean esVacia() {
        boolean respuesta = true;
        if (this.cabecera != null) {
            respuesta = false;
        }
        return respuesta;
    }

    public String toString() {
        String muestra = " [";
        NodoLista aux = this.cabecera;

        for (int i = 1; i <= this.longitud(); i++) {
            muestra = muestra + "," + aux.getElemento();
            aux = aux.getEnlace();
        }
        muestra = muestra + "]";

        return muestra;
    }

    public Lista clone() {
        Lista listaClonada = new Lista();
        NodoLista aux, aux2, aux3;
        if (this.cabecera != null) {
            aux = this.cabecera;
            listaClonada.cabecera = new NodoLista(cabecera.getElemento());
            aux2 = listaClonada.cabecera;
            while (aux.getEnlace() != null) {
                aux = aux.getEnlace();
                aux3 = new NodoLista(aux.getElemento());
                aux2.setEnlace(aux3);
                aux2 = aux2.getEnlace();

            }
        }

        return listaClonada;
    }

    public void invertir() {
        NodoLista anterior = this.cabecera;
        invertirAux(this.cabecera);
        if (anterior != null) {
            anterior.setEnlace(null);
        }
    }

    private void invertirAux(NodoLista nodo) {
        if (nodo != null) {
            this.cabecera = nodo;
            invertirAux(nodo.getEnlace());
            if (nodo.getEnlace() != null) {
                nodo.getEnlace().setEnlace(nodo);
            }
        }
    }

    //[0,1,2,0,3,4,5]
    public void agregarElem(Object nuevo, int x) {
        //nuevo elemento
        //x=2 posicion que quiero agregar el nuevo elem
        int cont = 0;

        if (this.cabecera != null) {
            NodoLista elemento = new NodoLista(nuevo);
            //agrego el elemento y enlazo todo 
            this.cabecera = new NodoLista(nuevo, this.cabecera);

            NodoLista aux = this.cabecera;
            while (aux.getEnlace() != null) {
                aux = aux.getEnlace();
                cont++;
                if (cont == x) {
                    elemento.setEnlace(aux.getEnlace());
                    aux.setEnlace(elemento);
                    cont=0;
                    aux=aux.getEnlace();
                }
            }
        }
    }
}
