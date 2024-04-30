
package com.mycompany.matrizortogonal;

class NodoVehiculo {
    
    String placa;
    String color;
    String linea;
    String modelo;
    String propietario;
    NodoVehiculo siguienteFila;
    NodoVehiculo siguienteColumna;

    public NodoVehiculo(String placa, String color, String linea, String modelo, String propietario) 
    {
        this.placa = placa;
        this.color = color;
        this.linea = linea;
        this.modelo = modelo;
        this.propietario = propietario;
        this.siguienteFila = null;
        this.siguienteColumna = null;
    }
}
