
package com.mycompany.matrizortogonal;

public class NodoFila {
    
    int fila;
    NodoVehiculo siguienteFila;
    NodoColumna siguienteColumna;

    
    public NodoFila(int fila) 
    {
        this.fila = fila;
        this.siguienteFila = null;
        this.siguienteColumna = null;
    }
}