/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas2020;

/**
 *
 * @author Carla Nuñez
 */
public class Lista {

    private Nodo cabecera;

    public Lista() {
        this.cabecera = null;
    }

    public boolean insertar(Object elemento, int pos) {
        boolean respuesta = true;
        if (pos < 1 || pos > this.longitud() + 1) {

            respuesta = false;
        } else if (pos == 1) {
            this.cabecera = new Nodo(elemento, this.cabecera);

        } else {
            //avanza hasta el elemento en posicion -1                 
            Nodo aux = this.cabecera;
            int i = 1;
            while (i < pos - 1) {
                aux = aux.getEnlace();
                i++;
            }
            //crea el nodo y lo enlaza
            Nodo nuevo = new Nodo(elemento, aux.getEnlace());
            aux.setEnlace(nuevo);
        }
        return respuesta;
    }

    public int longitud() {
        Nodo nuevoNodo = this.cabecera;
        int contador = 1;
        if (nuevoNodo == null) {
            contador = 0;
        } else {
            while (nuevoNodo.getEnlace() != null) {
                nuevoNodo = nuevoNodo.getEnlace();
                contador++;
            }
        }
        return contador;
    }

    public boolean eliminar(int pos) {
        boolean resultado = false;
        Nodo nuevoNodo;

        if (pos >= 1 && pos <= this.longitud()) {
            if (pos == 1) {
                cabecera = cabecera.getEnlace();

            } else {
                int i = 1;
                nuevoNodo = cabecera;
                while (i < pos - 1) {
                    nuevoNodo = nuevoNodo.getEnlace();

                    i++;

                }

                nuevoNodo.setEnlace(nuevoNodo.getEnlace().getEnlace());
            }
            resultado = true;

        }
        return resultado;
    }

    public int localizar(Object elemento) {
        int pos = 1;
        Nodo aux = this.cabecera;

        boolean exito = true;
        while (exito && aux != null) {
            if (aux.getElem().equals(elemento)) {
                exito = false;
            } else {
                aux = aux.getEnlace();
                pos++;
            }

        }
        if (exito == true) {
            pos = -1;
        }
        return pos;
    }

    public Object recuperar(int pos) {
        Object elemento = null;
        boolean respuesta = false;
        int i = 1;
        Nodo nuevo = this.cabecera;

        if (pos >= 1 && pos <= this.longitud()) {
            while (i <= this.longitud() && !respuesta) {
                if (i == pos) {
                    elemento = nuevo.getElem();
                    respuesta = true;
                } else {
                    nuevo = nuevo.getEnlace();
                    i++;
                }

            }

        }
        return elemento;
    }

    public boolean esVacia() {
        boolean respuesta = false;
        if (this.cabecera == null) {
            respuesta = true;
        }
        return respuesta;
    }

    @Override
    public Lista clone() {
        Lista listaClonada = new Lista();
        if (this.cabecera == null) {
            listaClonada = null;
        } else {
            Nodo aux = this.cabecera;
            Nodo aux2;
            listaClonada.cabecera = new Nodo(aux.getElem());
            aux2 = listaClonada.cabecera;
            aux = aux.getEnlace();
            while (aux != null) {
                Nodo nodoNuevo = new Nodo(aux.getElem());
                aux2.setEnlace(nodoNuevo);
                aux2 = nodoNuevo;
                aux = aux.getEnlace();
            }

        }
        return listaClonada;
    }

    public void vaciar() {
        this.cabecera = null;
    }

    @Override
    public String toString() {
        String salida = " ";
        if (this.cabecera == null) {
            salida = "Lista vacia";
        } else {
            salida = "[";
            // se ubica al principio de la estructura
            Nodo aux = this.cabecera;

            // recorre los nodos hasta el final
            while (aux != null) {
                // agrega el elemento al string
                salida += aux.getElem();
                // avanza al siguiente nodo
                aux = aux.getEnlace();
                if (aux != null) {
                    salida += ",";
                }

            }
            salida += "]";
        }
        return salida;
    }

    public void insertarPromedio() {
        int i, suma = 0, div = 0, promedio;
        Nodo aux = this.cabecera;

        while (aux.getEnlace() != null) {
            suma = (int) aux.getElem() + suma;
            div = div + 1;
            aux = aux.getEnlace();

        }
        suma = (int) aux.getElem() + suma;
        div = div + 1;
        promedio = suma / div;
        if (aux.getEnlace() == null) {
            Nodo aux2 = new Nodo(promedio);
            aux.setEnlace(aux2);
        }

    }

    public void eliminarRepetido(int x) {
        Nodo aux = this.cabecera;
        while (aux.getEnlace() != null) {

            if (this.cabecera.getElem().equals(x)) {
                this.cabecera = aux.getEnlace();
                aux = aux.getEnlace();
            } else if (aux.getEnlace().getElem().equals(x)) {
                aux.setEnlace(aux.getEnlace().getEnlace());
            } else {
                aux = aux.getEnlace();
            }

        }
        if (this.cabecera.getEnlace() == null) {
            if (this.cabecera.getElem().equals(x)) {
                this.cabecera = null;
            }
        }
    }

    public void calcularPromedio(int cantidad) {
        Nodo aux;
        int contador = 1;
        int promedio = 0;
        aux = this.cabecera;
        while (aux.getEnlace() != null) {
            if (contador < cantidad) {
                promedio = promedio + (int) aux.getElem();
                contador++;
            } else {
                promedio = promedio + (int) aux.getElem();
                Nodo aux2;
                aux2 = new Nodo(promedio);
                aux2.setEnlace(aux.getEnlace());
                aux.setEnlace(aux2);
                promedio = 0;
                contador = 1;
                aux = aux.getEnlace();

            }
            aux = aux.getEnlace();

        }
        if (promedio != 0) {
            promedio = promedio + (int) aux.getElem();
            Nodo aux3 = new Nodo(promedio);
            aux3.setEnlace(aux.getEnlace());
            aux.setEnlace(aux3);
            aux3.setElemento(promedio);

        }
    }
//
//    public void agregarElem(Object nuevo, int x) {
//        nuevo elemento
//        x=2 posicion que quiero agregar el nuevo elem
//        int cont = 0;
//
//        if (this.cabecera != null) {
//            Nodo elemento = new Nodo(nuevo);
//            agrego el elemento y enlazo todo 
//            this.cabecera = new Nodo(nuevo, this.cabecera);
//
//            Nodo aux = this.cabecera;
//
//            while (aux.getEnlace() != null) {
//                aux = aux.getEnlace();
//                cont++;
//
//                if (cont == x) {
//                    elemento.setEnlace(aux.getEnlace());
//                    aux.setEnlace(elemento);
//                    cont = 0;
//                    aux = aux.getEnlace();
//                }
//
//            }
//        }
//    }

    public void agregarElem(Object nuevo, int x) {
        if (this.cabecera != null) {
            this.cabecera = new Nodo(nuevo, this.cabecera);
            Nodo aux2 = this.cabecera;
            Nodo aux3 = new Nodo();
            int i = 1;

            while (aux2.getEnlace() != null) {

                aux2 = aux2.getEnlace();
                
                if (i == x) {
                    Nodo aux = new Nodo(nuevo);
                    aux3 = aux2.getEnlace();
                    aux.setEnlace(aux3);
                    aux2.setEnlace(aux);
                    aux2 = aux2.getEnlace();
                    i = 0;
                }
                i++;
            }
        }
    }
}
