
package com.mycompany.matrizortogonal;

public class NodoColumna 
{
    int columna;
    NodoVehiculo siguienteFila;
    NodoColumna siguienteColumna;

    public NodoColumna(int columna)
    {
        this.columna = columna;
        this.siguienteFila = null;
        this.siguienteColumna = null;
    }
}