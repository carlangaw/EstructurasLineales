/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas2020;

import lineales.dinamicas.*;

/**
 *
 * @author Carla Nuñez
 */
public class NodoCola {
    private Object elemento;
    private NodoCola enlace;
public NodoCola (Object elemento, NodoCola enlace){
     this.elemento=elemento;
    this.enlace=enlace;
    
}
public NodoCola (Object elemento){
    this.elemento=elemento;
}
public NodoCola (NodoCola enlace){
    this.enlace=enlace;
    
}
public Object getElemento(){
    return this.elemento;
    
}
public NodoCola getEnlace(){
    return this.enlace;
}
public void setElemento(Object elemento){
    this.elemento=elemento;
}
public void setEnlace(NodoCola enlace){
    this.enlace=enlace;
}
}
