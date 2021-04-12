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
public class Pila {
    private NodoPila tope;

public Pila(){
    this.tope=null;
}

public boolean apilar (Object elemento){
    boolean respuesta=true;
    NodoPila nuevo = new NodoPila(elemento,this.tope);
    this.tope=nuevo;
    
    return respuesta;
}
public boolean desapilar(){
   boolean respuesta=false;
   if(this.tope!=null){
       this.tope=this.tope.getEnlace();
       respuesta=true;
   }
   return respuesta;
}
public void vaciar (){
    this.tope=null;
}
public boolean esVacia(){
    boolean respuesta=false;
    if(tope==null){
        respuesta=true;
    }
    return respuesta;
}
public Object obtenerTope(){
    Object tope;
    if(this.tope!=null){
        tope=this.tope.getElemento();
        return tope;
    }else{
        tope=this.tope;
    }
   return tope;
}
//public String toString(){
//    String muestra="  ";
//    
//  if(this.tope==null){
//      muestra="Pila Vacia";
//  }else{
//      NodoPila aux =this.tope;
//      muestra="[";
//  
//  while(aux!=null){
//     muestra+=","+aux.getElemento().toString();
//     aux=aux.getEnlace();
//     if(aux!=null){
//         muestra=muestra+"]";
//     }
//  }
//  
//  
//}
//  return muestra;
//}

public String toString() {
    String salida = "";
    if (this.tope == null) {
        salida = "Pila vacia";
    } else {
        salida = "[";
        // se ubica al principio de la estructura
        NodoPila aux = this.tope;
        
        // recorre los nodos hasta el final
        while (aux != null) {
            // agrega el elemento al string
            salida += aux.getElemento();
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
public Pila clone (){
  Pila pilaClonada =new Pila();
  NodoPila aux,aux2,aux3;
  if(this.tope!=null){
      aux=this.tope;
      pilaClonada.tope=new NodoPila(tope.getElemento());
      aux2=pilaClonada.tope;
      while(aux.getEnlace()!=null){
          aux=aux.getEnlace();
          aux3=new NodoPila(aux.getElemento());
          aux2.setEnlace(aux3);
          aux2=aux2.getEnlace();
          
      }
  }
 
  return pilaClonada;
}
   
}
