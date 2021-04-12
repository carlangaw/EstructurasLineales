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
class NodoPila {
    private Object elemento;
    private NodoPila enlace;
    
public NodoPila (Object elemento,NodoPila enlace){
    this.elemento=elemento;
    this.enlace=enlace;
}
public NodoPila(Object elemento){
    this.elemento=elemento;
    
}
public Object getElemento(){
    return elemento;
}
public void setElemento(Object elemento){
    this.elemento=elemento;
}
public NodoPila getEnlace(){
    return enlace;
}
public void setEnlace(NodoPila enlace){
    this.enlace=enlace;
}
}
